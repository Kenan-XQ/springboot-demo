package com.example.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogTest {

    @Test
    public void testLog() {
        log.info("级别：{}, 输出：{}", "info", "hello world");
        log.warn("级别：{}, 输出：{}", "warn", "hello world");
        log.error("级别：{}, 输出：{}", "error", "hello world");
    }
}
