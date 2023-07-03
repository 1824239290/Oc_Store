package com.jumusu.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 橘木苏_Oc
 * @Description: 地址结合参数接受
 * @Date 2023/7/3 11:55
 */
@Data
public class AddressListParam {
    @NotNull
    @JsonProperty("user_id")
    private Integer userId;

}
