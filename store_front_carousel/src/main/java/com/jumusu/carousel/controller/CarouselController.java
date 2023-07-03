package com.jumusu.carousel.controller;

import com.jumusu.carousel.service.CarouselService;
import com.jumusu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 橘木苏_Oc
 * @Description: 轮播图的控制类
 * @Date 2023/7/3 14:03
 */
@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    /**
     * 查询轮播图数据，只要优先级最高的六张
     * @return
     */
    @PostMapping("list")
    public R list(){
        return carouselService.list();
    }
}
