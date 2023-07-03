package com.jumusu.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: 橘木苏_Oc
 * @Description: 地址删除参数
 * @Date 2023/7/3 12:21
 */
@Data
public class AddressRemoveParam {
    @NotNull
    private Integer id;
}
