package com.jumusu.param;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: 橘木苏_Oc
 * @Description: 商品id参数
 * @Date 2023/7/3 20:25
 */
@Data
public class ProductIdParam {
    @NotNull
    private Integer productID;
}
