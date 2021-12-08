package com.example.anno.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableDubbo(scanBasePackages = "com.example.anno")
@ComponentScan(value = {"com.example.anno"})
public class Config {

    /**
     * 应用配置
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("dubbo-anno-consumer");
        Map<String, String> map = Map.of(
                "qos.enable", "true",
                "qos.accept.foreign.ip", "false",
                "qos.port", "8900"
        );
        config.setParameters(map);
        config.setOwner("qgs");
        return config;
    }

    /**
     * 服务消费者配置
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig config = new ConsumerConfig();
        config.setTimeout(3000);
        return config;
    }

    /**
     * 配置注册中心
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("localhost");
        config.setPort(2181);
        return config;
    }
}
