package com.example.demo;

import com.example.demo.repository.es.EsBlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEs() {
        esBlogRepository.findAll().forEach(System.out::println);
    }

}
