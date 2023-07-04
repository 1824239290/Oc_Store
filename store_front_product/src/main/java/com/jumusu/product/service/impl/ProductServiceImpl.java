package com.jumusu.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jumusu.clients.CategoryClient;
import com.jumusu.param.ProductHotParam;
import com.jumusu.param.ProductIdParam;
import com.jumusu.param.ProductIdsParam;
import com.jumusu.pojo.Picture;
import com.jumusu.pojo.Product;
import com.jumusu.product.mapper.PictureMapper;
import com.jumusu.product.mapper.ProductMapper;
import com.jumusu.product.service.ProductService;
import com.jumusu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 17:12
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PictureMapper pictureMapper;
    //引入feign客户端，需要在启动类加配置注解
    @Autowired
    private CategoryClient categoryClient;
    /**
     * 根据单类别名称，查询热门商品，至多7条数据
     *
     * @param categoryName
     * @return
     */
    @Override
    public R promo(String categoryName) {
        //根据类别名称调用feign客户端，访问类别服务获取类别数据
        R r = categoryClient.byName(categoryName);
        if (r.getCode().equals(R.FAIL_CODE)){
            log.info("ProductServiceImpl.promo业务，结果{}","类别查询失败！");
            return r;
        }
        //类服务中，data = category  feign{json} ---product服务
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) r.getData();
        Integer categoryId = (Integer) map.get("category_id");

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id",categoryId);
        queryWrapper.orderByDesc("product_sales");

        IPage<Product> page = new Page<>(1,7);
        //返回的是包装数据，内部含有对应商品的集合，总页数，总条数等
        page = productMapper.selectPage(page, queryWrapper);
        List<Product> records = page.getRecords();
        log.info("ProductServiceImpl.promo业务，结果{}",records);
        return R.ok("数据查询成功",records);
    }

    /**
     * 多类别热门商品查询，根据类别名称集合，最多查7条。
     *
     * @param param
     * @return
     */
    @Override
    public R hots(ProductHotParam param) {
        //调用类别服务
        R r = categoryClient.hostCategory(param);
        if (r.getCode().equals(R.FAIL_CODE)){
            log.info("ProductServiceImpl.hots业务，结果{}","类别查询失败！");
            return r;
        }
        List<Object> ids = (List<Object>) r.getData();
        //类别集合id查询商品
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id",ids);
        queryWrapper.orderByDesc("product_sales");
        IPage<Product> page = new Page<>(1,7);
        page = productMapper.selectPage(page, queryWrapper);
        List<Product> records = page.getRecords();
        R ok = R.ok("多类别热门商品查询成功", records);
        //结果集合封装
        log.info("ProductServiceImpl.hots业务，结果{}",records);
        return ok;
    }

    /**
     * 查询类别商品集合
     *
     * @return
     */
    @Override
    public R clist() {
        R list = categoryClient.list();
        log.info("ProductServiceImpl.list业务结束，结果{}",list);
        return list;
    }

    /**
     * 通用型业务
     * 传入id，根据id查
     * 没有id，查全部
     *
     * @param param
     * @return
     */
    @Override
    public R byCategory(ProductIdsParam param) {
        List<Integer> categoryID = param.getCategoryID();
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (!categoryID.isEmpty()){
            queryWrapper.in("category_id",categoryID);
        }
        IPage<Product> page = new Page<>(param.getCurrentPage(),param.getPageSize());
        page = productMapper.selectPage(page,queryWrapper);

        R ok = R.ok("查询成功",page.getRecords(),page.getTotal());
        log.info("ProductServiceImpl.byCategory业务结束，结果{}",ok);
        return ok;
    }

    /**
     * 根据商品id查询商品详情信息
     *
     * @param param
     * @return
     */
    @Override
    public R detail(ProductIdParam param) {
        Product product = productMapper.selectById(param.getProductID());
        R ok = R.ok(product);
        log.info("ProductServiceImpl.detail业务结束，结果{}",ok);
        return ok;
    }

    /**
     * 查询商品对应的详情集合
     *
     * @param param
     * @return
     */
    @Override
    public R pictures(ProductIdParam param) {
        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",param.getProductID());
        List<Picture> pictures = pictureMapper.selectList(queryWrapper);

        R ok = R.ok(pictures);
        log.info("ProductServiceImpl.picture业务结束，结果{}",ok);
        return ok;
    }

    /**
     * 搜索服务调用获取全部商品数据集合
     *
     * @return
     */
    @Override
    public List<Product> allList() {
        List<Product> productList = productMapper.selectList(null);
        log.info("ProductServiceImpl.allList业务结束，结果{}",productList);
        return productList;
    }
}
