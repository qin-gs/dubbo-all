package com.example.anno.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描指定包下被 @Service 注解的类
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.example.anno")
public class Config {

    /**
     * 服务提供者信息配置
     */
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig config = new ProviderConfig();
        config.setTimeout(3000);
        return config;
    }

    /**
     * 分布式应用信息配置
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("dunno-annotation-provider");
        return config;
    }

    /**
     * 注册中心信息配置
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("localhost");
        config.setPort(2181);
        return config;
    }

    /**
     * 使用协议配置
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20890);
        return config;
    }
}
