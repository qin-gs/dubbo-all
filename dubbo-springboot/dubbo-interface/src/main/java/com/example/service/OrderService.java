package com.example.service;

import com.example.bean.UserAddress;

import java.util.List;

public interface OrderService {

    /**
     * 初始化订单
     */
    List<UserAddress> initOrder(String userId);

}
