package com.jumusu.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 橘木苏_Oc
 * @Description: 接受前端参数的param
 * @Date 2023/7/2 20:00
 * TODO: 要使用jsr 303的注解 进行参数校验
 * @NotBlank 字符串不能为null，和空字符串
 * @NotNull 不能为空但可以为空字符串
 * @NotEmpty 集合不能长度为0
 */
@Data
public class UserCheckParam {
    @NotBlank
    private String userName;//注意：参数名称和前端json的key的名称
}
