package com.jumusu.user.controller;

import com.jumusu.param.UserCheckParam;
import com.jumusu.param.UserLoginParam;
import com.jumusu.pojo.User;
import com.jumusu.user.service.UserService;
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
 * @Date 2023/7/2 20:06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 检查账号是否可以使用的接口
     * @param userCheckParam 接受账号的参数
     * @param result 获取校验结果
     * @return 返回封装结果R对象
     */
    @PostMapping("check")
    public R check(@RequestBody @Validated UserCheckParam userCheckParam, BindingResult result){
        //检查是否符合校验注解的规则，符合false，不符合true
        boolean b = result.hasErrors();
        if (b){
            return R.fail("账号为空，不可使用");
        }
        return userService.check(userCheckParam);
    }

    /**
     * 注册账号
     * @param user 前端传来的用户学习
     * @param result 校验结果
     * @return 返回封装结果R对象
     */
    @PostMapping("register")
    public R register(@RequestBody @Validated User user, BindingResult result){
        if (result.hasErrors()){
            //如果存在，请求参数不符合
            return R.fail("参数异常，不可注册");
        }
        return userService.register(user);
    }
    @PostMapping("login")
    public R login(@RequestBody @Validated UserLoginParam userLoginParam,BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数异常，不可登录！");
        }
        return userService.login(userLoginParam);
    }
}
