package com.example;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.example.service.ProviderService;
import com.example.service.ProviderServiceImpl;

import java.io.IOException;

/**
 * 代码实现，用于测试
 */
public class DubboProviderApiApplication {

    public static void main(String[] args) throws IOException {
        // 服务的实现类
        ProviderService service = new ProviderServiceImpl();

        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider");
        applicationConfig.setOwner("qgs");

        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        // 服务提供者协议配置
        // ServiceConfig 为重对象，内部封装了与注册中心的连接，以及开启服务端口
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        // 服务提供者暴露服务配置
        ServiceConfig<ProviderService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        // 可以配置多个注册中心 多个协议
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(ProviderService.class);
        serviceConfig.setRef(service);
        serviceConfig.setVersion("1.0.0");

        // 暴露并注册服务
        serviceConfig.export();

        System.in.read();
    }
}
