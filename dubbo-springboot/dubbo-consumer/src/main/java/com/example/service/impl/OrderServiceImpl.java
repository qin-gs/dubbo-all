package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.bean.UserAddress;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }

    public List<UserAddress> hello(String userId) {
        return List.of(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }

}
