package com.jumusu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/2 19:55
 */
@Data
@TableName("user")
public class User implements Serializable {
    public static final Long seriaVersionUID = 1L;

    @JsonProperty("user_id")//jackson的注解，用于json互转
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @Length(min = 6)
    private String userName;

//    @JsonIgnore // 忽略属性，不生产json也不接受
    @JsonInclude(JsonInclude.Include.NON_NULL) // 接收json，但如果是空，就不返回json
    @NotBlank
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank
    private String userPhonenumber;
}
