package com.jumusu.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description: 热门商品参数
 * @Date 2023/7/3 18:25
 */
@Data
public class ProductHotParam {
    @NotEmpty
    private List<String> categoryName;
}
