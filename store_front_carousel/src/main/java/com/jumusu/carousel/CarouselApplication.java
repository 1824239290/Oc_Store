package com.jumusu.carousel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 14:01
 */
@MapperScan(basePackages = "com.jumusu.carousel.mapper")
@SpringBootApplication
public class CarouselApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarouselApplication.class,args);
    }
}
