package com.jumusu.product.controller;

import com.jumusu.pojo.Product;
import com.jumusu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/4 14:40
 */
@RestController
@RequestMapping("product")
public class ProductSearchController {
    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public List<Product> allList(){
        return productService.allList();
    }
}
