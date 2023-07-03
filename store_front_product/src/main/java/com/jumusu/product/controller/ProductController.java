package com.jumusu.product.controller;

import com.jumusu.param.ProductHotParam;
import com.jumusu.param.ProductIdParam;
import com.jumusu.param.ProductIdsParam;
import com.jumusu.param.ProductPromoParam;
import com.jumusu.product.service.ProductService;
import com.jumusu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 17:07
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/promo")
    public R promo(@RequestBody @Validated ProductPromoParam param, BindingResult result){
        if (result.hasErrors()){
            return R.fail("数据查询失败");
        }
        return productService.promo(param.getCategoryName());
    }
    @PostMapping("hots")
    public R hots(@RequestBody @Validated ProductHotParam param, BindingResult result){
        if (result.hasErrors()){
            return R.fail("数据查询失败");
        }
        return productService.hots(param);
    }
    @PostMapping("category/list")
    public R clist(){
        return productService.clist();
    }
    @PostMapping("bycategory")
    public R byCategory(@RequestBody @Validated ProductIdsParam param, BindingResult result){
        if (result.hasErrors()){
            return R.fail("类别商品查询失败");
        }
        return productService.byCategory(param);
    }
    @PostMapping("all")
    public R all(@RequestBody @Validated ProductIdsParam param,BindingResult result){
        if (result.hasErrors()){
            return R.fail("类别商品查询失败");
        }
        return productService.byCategory(param);
    }
    @PostMapping("detail")
    public R detail(@RequestBody @Validated ProductIdParam param ,BindingResult result){
        if (result.hasErrors()) {
            return R.fail("商品详情查询失败");
        }
        return productService.detail(param);
    }
    @PostMapping("pictures")
    public R pictures(@RequestBody @Validated ProductIdParam param,BindingResult result){
        if (result.hasErrors()) {
            return R.fail("图片查询失败");
        }
        return productService.pictures(param);
    }
}
