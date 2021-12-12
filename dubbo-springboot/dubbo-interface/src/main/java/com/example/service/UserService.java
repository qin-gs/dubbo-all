package com.example.service;

import com.example.bean.UserAddress;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 按照用户id返回所有的收货地址
     */
    List<UserAddress> getUserAddressList(String userId);

}
