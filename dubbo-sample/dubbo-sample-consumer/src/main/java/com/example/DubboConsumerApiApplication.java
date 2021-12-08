package com.example;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.example.service.ProviderService;

import javax.print.PrintService;

public class DubboConsumerApiApplication {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer");
        applicationConfig.setOwner("qgs");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2881");

        ReferenceConfig<ProviderService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(PrintService.class);

        ProviderService providerService = referenceConfig.get();
        providerService.sayHello("world");
    }
}
