package com.jumusu.category.controller;

import com.jumusu.category.service.CategoryService;
import com.jumusu.param.ProductHotParam;
import com.jumusu.utils.R;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 16:52
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/promo/{categoryName}")
    public R byName(@PathVariable String categoryName){
        if (StringUtils.isEmpty(categoryName)){
            return R.fail("类别名称为null，无法查询");
        }
        return categoryService.byName(categoryName);
    }
    @PostMapping("hots")
    public R hostCategory(@RequestBody @Validated ProductHotParam productHotParam, BindingResult result){
        if (result.hasErrors()){
            return R.fail("类别查询失败");
        }
        return categoryService.hotsCategory(productHotParam);
    }
    @GetMapping("list")
    public R list(){
        return categoryService.list();
    }
}
