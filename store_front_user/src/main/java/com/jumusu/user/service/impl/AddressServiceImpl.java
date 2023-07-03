package com.jumusu.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jumusu.pojo.Address;
import com.jumusu.user.mapper.AddressMapper;
import com.jumusu.user.service.AddressService;
import com.jumusu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 橘木苏_Oc
 * @Description: 地址业务实现类
 * @Date 2023/7/3 12:03
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public R list(Integer userId) {
        //数据查询
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Address> addressList = addressMapper.selectList(queryWrapper);
//        结果封装
        log.info("AddressService.list业务结束，结果：{}","查询成功");
        return R.ok("查询成功",addressList);
    }

    @Override
    public R save(Address address) {
        //插入数据
        int rows = addressMapper.insert(address);
        //插入成功返回数据结合
        if (rows == 0){
            log.info("AddressServiceImpl.save业务结束，结果{}","地址插入失败");
            return R.fail("插入地址失败");
        }
        log.info("AddressServiceImpl.save业务结束，结果{}","插入成功，返回新的数据集合");
        return list(address.getUserId());
    }

    /**
     * 根据id，删除地址数据
     * @param id 地址id，已经校验
     * @return 结果 001 004
     */
    @Override
    public R remove(Integer id) {
        int rows = addressMapper.deleteById(id);
        if (rows == 0){
            log.info("AddressServiceImpl.remove业务结束，结果{}","删除地址数据失败");
            return R.fail("删除地址数据失败！");
        }
        log.info("AddressServiceImpl.remove业务结束，结果{}","地址删除成功");
        return R.ok("地址删除成功!");
    }
}
