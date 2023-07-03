package com.jumusu.user.service;

import com.jumusu.pojo.Address;
import com.jumusu.utils.R;

/**
 * @Author: 橘木苏_Oc
 * @Description:
 * @Date 2023/7/3 12:03
 */
public interface AddressService {
    /**
     * 查询用户的地址列表
     * @param userId 用户id，已经校验
     * @return 结果 001/004
     */
    R list(Integer userId);

    /**
     * 插入地址数据，插入成功后返回新的数据集合
     * @param address 地址数据，已经校验
     * @return 数据集合
     */
    R save(Address address);

    /**
     * 根据id，删除地址数据
     * @param id 地址id，已经校验
     * @return 结果 001 004
     */
    R remove(Integer id);
}
