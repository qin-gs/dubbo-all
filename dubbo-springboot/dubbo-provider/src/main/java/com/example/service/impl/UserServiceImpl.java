package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.bean.UserAddress;
import com.example.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        log.info("UserServiceImpl");
        UserAddress address1 = new UserAddress(1, "address-1", "1", "qqq", "1234567890", "Y");
        UserAddress address2 = new UserAddress(2, "address-2", "2", "www", "0123456789", "N");

        return Arrays.asList(address1, address2);
    }

}
