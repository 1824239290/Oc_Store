package com.jumusu.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/2 19:43
 */
@SpringBootApplication
@MapperScan(basePackages = "com.jumusu.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
