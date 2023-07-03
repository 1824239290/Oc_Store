package com.jumusu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 16:33
 */
@Data
@TableName("product")
public class Product implements Serializable {
    public static final Long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("product_title")
    private String productTitle;
    @JsonProperty("product_intro")
    private String productIntro;
    @JsonProperty("product_picture")
    private String productPicture;
    @JsonProperty("product_price")
    private Double productPrice;
    @JsonProperty("product_selling_price")
    private Double productSellingPrice;
    @JsonProperty("product_num")
    private Integer productNum;
    @JsonProperty("product_sales")
    private Integer productSales;

}
