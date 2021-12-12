package com.example;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 开启服务容错
 * <p>
 * dubbo 整合 springboot 的三种方式
 * 1. 导入 dubbo-starter 在 properties 配置文件中配置属性，使用 @Service 暴露服务，@Reference 引用服务
 * 2. 导入 dubbo-starter 继续使用 xml 文件，通过 @ImportResource("provider.xml") 引入
 * 3. 使用 配置类，手动创建每一个组件，通过 @EnableDubbo(scanBasePackages = "com.example") 扫描
 */
@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
