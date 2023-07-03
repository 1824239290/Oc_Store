package com.jumusu.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jumusu.constannts.UserConstants;
import com.jumusu.param.UserCheckParam;
import com.jumusu.param.UserLoginParam;
import com.jumusu.pojo.User;
import com.jumusu.user.mapper.UserMapper;
import com.jumusu.user.service.UserService;
import com.jumusu.utils.MD5Util;
import com.jumusu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/2 20:17
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public R check(UserCheckParam userCheckParam) {
        //参数封装
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userCheckParam.getUserName());
        //数据库查询
        Long count = userMapper.selectCount(queryWrapper);
        //查询结果处理
        if (count == 0){
            //数据库不存在可用
            log.info("UserServiceImpl.check业务结束，账号可用");
            return R.ok("账号不存在，可用使用");
        }
        return R.fail("账号已存在，不可使用。");
    }

    @Override
    public R register(User user) {
        //检查账号是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        Long count = userMapper.selectCount(queryWrapper);
        if (count >0){
            log.info("UserService.register业务结束，结果：{}","账号存在，注册失败");
            return R.fail("账号存在，不可注册！");
        }
        //密码加密
        String newPwd = MD5Util.encode(user.getPassword() + UserConstants.USER_SLAT);
        user.setPassword(newPwd);
        //插入数据库
        int rows = userMapper.insert(user);
        if (rows == 0){
            log.info("UserService.register业务结束，结果：{}","插入数据失败，注册失败");
            return R.fail("注册失败，请稍后再试");
        }
        //返回封装结果
        log.info("UserService.register业务结束，结果：{}","注册成功");
        return R.ok("注册成功");
    }

    @Override
    public R login(UserLoginParam userLoginParam) {
        //加盐密码处理
        String newPwd = MD5Util.encode(userLoginParam.getPassword() + UserConstants.USER_SLAT);
        //数据库查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userLoginParam.getUserName());
        queryWrapper.eq("password",newPwd);
        User user = userMapper.selectOne(queryWrapper);

        //结果处理
        if (user == null){
            log.info("UserService.login业务结束，结果：{}","账号密码错误，登录失败");
            return R.fail("账号密码错误，登录失败！");
        }
        log.info("UserService.login业务结束，结果：{}","登录成功");
        //不返回password
        user.setPassword(null);
        return R.ok("登录成功",user);
    }
}
