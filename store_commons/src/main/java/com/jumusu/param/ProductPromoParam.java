package com.jumusu.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 橘木苏_Oc
 * @Description: 类别热门商品参数接受
 * @Date 2023/7/3 16:32
 */
@Data
public class ProductPromoParam {
    @NotBlank
    private String categoryName;
}
