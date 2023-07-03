package com.jumusu.user.service;

import com.jumusu.param.UserCheckParam;
import com.jumusu.param.UserLoginParam;
import com.jumusu.pojo.User;
import com.jumusu.utils.R;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/2 20:14
 */
public interface UserService {
    /**
     * 检查账号是否可用
     * @param userCheckParam 账号参数
     * @return 结果，001/004
     */
    R check(UserCheckParam userCheckParam);

    /**
     * 注册业务
     * @param user 参数已经校验，密码为明文
     * @return 结果001/004
     */
    R register(User user);

    /**
     * 登录业务
     * @param userLoginParam 账号和密码 密码明文
     * @return 结果 001/004
     */
    R login(UserLoginParam userLoginParam);
}
