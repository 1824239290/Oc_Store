package com.jumusu.carousel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jumusu.carousel.mapper.CarouselMapper;
import com.jumusu.carousel.service.CarouselService;
import com.jumusu.pojo.Carousel;
import com.jumusu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 14:12
 */
@Service
@Slf4j
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;
    /**
     * 查询优先级最高的六条轮播图
     *
     * @return
     */
    @Override
    public R list() {
        QueryWrapper<Carousel> carouselQueryWrapper = new QueryWrapper<>();
        carouselQueryWrapper.orderByDesc("priority");
        List<Carousel> list = carouselMapper.selectList(carouselQueryWrapper);
        //jdk 1.8 stream
        List<Carousel> collect = list.stream().limit(6).collect(Collectors.toList());
        R ok = R.ok(collect);
        log.info("CarouselServiceImpl.list业务结束，结果{}",ok);
        return ok;
    }
}
