package com.example;

import com.example.anno.ConsumerAnnoService;
import com.example.anno.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DubboConsumerAnnoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.start();

        ConsumerAnnoService service = context.getBean(ConsumerAnnoService.class);
        String s = service.doSayHi("annotation");
        System.out.println(s);
    }
}
