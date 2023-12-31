package com.jumusu.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jumusu.category.mapper.CategoryMapper;
import com.jumusu.category.service.CategoryService;
import com.jumusu.param.ProductHotParam;
import com.jumusu.pojo.Category;
import com.jumusu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 16:56
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 根据类别名称查询类别对象
     *
     * @param categoryName
     * @return
     */
    @Override
    public R byName(String categoryName) {
        //封装查询参数
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("category_name",categoryName);
        //查询数据库
        Category category = categoryMapper.selectOne(categoryQueryWrapper);
        //结果封装
        if (category == null){
            log.info("CategoryServiceImpl.byName业务结束，结果{}","查询失败");
            return R.fail("类别查询失败");
        }
        log.info("CategoryServiceImpl.byName业务结束，结果{}","查询成功");
        return R.ok("类别查询成功",category);
    }

    /**
     * 根据类别名称集合，返回类别对应的id集合
     *
     * @param productHotParam
     * @return
     */
    @Override
    public R hotsCategory(ProductHotParam productHotParam) {
        //封装查询参数
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_name",productHotParam.getCategoryName());
        queryWrapper.select("category_id");

        //查询数据库
        List<Object> ids = categoryMapper.selectObjs(queryWrapper);
        R ok = R.ok("类被查询成功", ids);
        log.info("CategoryServiceImpl.hotsCategory业务结束，结果{}","查询成功");
        return ok;
    }

    /**
     * 查询类别数据，进行返回
     *
     * @return 类别数据集合
     */
    @Override
    public R list() {
        List<Category> categoryList = categoryMapper.selectList(null);
        R ok = R.ok("查询成功", categoryList);
        log.info("CategoryServiceImpl.list业务结束，结果{}",ok);
        return ok;
    }
}
