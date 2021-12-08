package com.example;

import com.example.service.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboConsumerApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();

        ProviderService service = context.getBean(ProviderService.class);
        String s = service.sayHello("world");
        System.out.println(s);

        System.in.read();


    }
}
