package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("第一次测试");
        System.out.println("第二次测试");
        System.out.println("第三次测试");
        System.out.println("第四次测试");
        SpringApplication.run(DemoApplication.class, args);
    }

}
