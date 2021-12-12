package com.example.config;

import com.alibaba.dubbo.config.*;
import com.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// @Configuration
public class Config {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("provider");
        return config;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("localhost:2181");
        return config;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }

    @Bean
    public ServiceConfig<UserService> serviceConfig(UserService service) {
        ServiceConfig<UserService> config = new ServiceConfig<>();
        config.setInterface(UserService.class);
        config.setRef(service);
        config.setVersion("1.0");

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(3000);

        // MonitorConfig;
        // ProviderConfig;

        config.setMethods(List.of(methodConfig));
        return config;
    }
}
