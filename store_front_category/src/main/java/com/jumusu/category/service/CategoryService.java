package com.jumusu.category.service;

import com.jumusu.param.ProductHotParam;
import com.jumusu.utils.R;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 16:55
 */
public interface CategoryService {
    /**
     * 根据类别名称查询类别对象
     * @param categoryName
     * @return
     */
    R byName(String categoryName);

    /**
     * 根据类别名称集合，返回类别对应的id集合
     * @param productHotParam
     * @return
     */
    R hotsCategory(ProductHotParam productHotParam);

    /**
     * 查询类别数据，进行返回
     * @return 类别数据集合
     */
    R list();
}
