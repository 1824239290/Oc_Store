package com.jumusu.product.service;

import com.jumusu.param.ProductHotParam;
import com.jumusu.param.ProductIdParam;
import com.jumusu.param.ProductIdsParam;
import com.jumusu.utils.R;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 17:11
 */
public interface ProductService {
    /**
     * 根据单类别名称，查询热门商品，至多7条数据
     * @param categoryName
     * @return
     */
    R promo(String categoryName);

    /**
     * 多类别热门商品查询，根据类别名称集合，最多查7条。
     * @param param
     * @return
     */
    R hots(ProductHotParam param);

    /**
     * 查询类别商品集合
     * @return
     */
    R clist();

    /**
     * 通用型业务
     * 传入id，根据id查
     * 没有id，查全部
     * @param param
     * @return
     */
    R byCategory(ProductIdsParam param);

    /**
     * 根据商品id查询商品详情信息
     * @param param
     * @return
     */
    R detail(ProductIdParam param);

    /**
     * 查询商品对应的详情集合
     * @param param
     * @return
     */
    R pictures(ProductIdParam param);
}
