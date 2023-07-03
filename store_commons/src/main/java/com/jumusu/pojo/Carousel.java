package com.jumusu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;
import java.io.Serializable;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 14:03
 */
@Data
@TableName("carousel")
public class Carousel implements Serializable {
    public static final Long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @TableField("carousel_id")
    @JsonProperty("carousel_id")
    private Integer carouselId;
    @TableField("img_path")
    private String imgPath;
    private String describes;
    @JsonProperty("product_id")
    @TableField("product_id")
    private Integer productId;
    private Integer priority;
}
