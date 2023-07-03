package com.jumusu.user.controller;

import com.jumusu.param.AddressListParam;
import com.jumusu.param.AddressRemoveParam;
import com.jumusu.pojo.Address;
import com.jumusu.user.service.AddressService;
import com.jumusu.utils.R;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 橘木苏_Oc
 * @Description: 地址控制Controller
 * @Date 2023/7/3 11:58
 */
@RestController
@RequestMapping("user/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("list")
    public R list(@RequestBody @Validated AddressListParam addressListParam, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数异常，查询失败");
        }
        return addressService.list(addressListParam.getUserId());
    }
    @PostMapping("save")
    public R save(@RequestBody @Validated Address address,BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数异常，保存失败");
        }
        return addressService.save(address);
    }
    @PostMapping("remove")
    public R remove(@RequestBody @Validated AddressRemoveParam addressRemoveParam,BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数异常，删除失败");
        }
        return addressService.remove(addressRemoveParam.getId());
    }
}
