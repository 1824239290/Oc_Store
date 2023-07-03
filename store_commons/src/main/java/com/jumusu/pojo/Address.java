package com.jumusu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import sun.misc.InnocuousThread;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 11:51
 */
@Data
@TableName("address")
public class Address implements Serializable {
    public static final Long servalVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    @NotBlank
    private String linkman;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotNull
    @TableField("user_id")
    private Integer userId;
}
