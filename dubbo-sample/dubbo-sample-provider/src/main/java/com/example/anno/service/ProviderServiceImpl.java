package com.example.anno.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 配置 dubbo 服务的提供方
 */
@Service(timeout = 200)
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String word) {
        return word;
    }
}
