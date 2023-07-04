package com.jumusu.clients;

import com.jumusu.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/4 14:43
 */
@FeignClient(value = "product-service")
public interface ProductClient {
    /**
     * 搜索服务调用，进行全部数据查询，用于搜索数据库同步更新
     * @return
     */
    @GetMapping("/product/list")
    List<Product> allList();
}
