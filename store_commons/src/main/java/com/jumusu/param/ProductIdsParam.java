package com.jumusu.param;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 19:58
 */
@Data
public class ProductIdsParam {
    @NonNull
    private List<Integer> categoryID;
    private int currentPage = 1;
    private int pageSize = 15;

    public ProductIdsParam() {
    }
}
