package com.jumusu.clients;

import com.jumusu.param.ProductHotParam;
import com.jumusu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: 橘木苏_Oc
 * @Description: 类别调用接口
 * @Date 2023/7/3 17:04
 */
@FeignClient("category-service")
public interface CategoryClient {
    @GetMapping("/category/promo/{categoryName}")
    R byName(@PathVariable String categoryName);
    @PostMapping("/category/hots")
    R hostCategory(@RequestBody ProductHotParam productHotParam);
    @GetMapping("/category/list")
    R list();
}
