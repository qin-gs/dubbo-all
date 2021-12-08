package com.example;

import com.example.anno.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class DubboProviderAnnoApplication {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.start();
        System.in.read();
    }
}
