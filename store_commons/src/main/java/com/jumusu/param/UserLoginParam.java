package com.jumusu.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 橘木苏_Oc
 * @Description: 登录结合参数接受
 * @Date 2023/7/2 20:55
 */
@Data
public class UserLoginParam {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
