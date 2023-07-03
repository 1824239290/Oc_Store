package com.jumusu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 16:20
 */
@Data
@TableName("category")
public class Category {
    public static final Long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("category_name")
    private String categoryName;
}
