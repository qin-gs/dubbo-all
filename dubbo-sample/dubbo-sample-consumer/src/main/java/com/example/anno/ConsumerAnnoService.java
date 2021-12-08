package com.example.anno;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.anno.service.ProviderService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerAnnoService {

    /**
     * 引用服务端提供的类
     */
    @Reference
    private ProviderService providerService;

    public String doSayHi(String name) {
        return providerService.sayHello(name);
    }
}
