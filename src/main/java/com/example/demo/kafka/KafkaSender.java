package com.example.demo.kafka;

import com.example.demo.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: qizonghao
 * @Date: 2019-11-20
 * @Desc: kafka生产者
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    // 发送消息方法
    public void send(String content) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg("测试消息: " + content);
        message.setSendTime(new Date());
        log.info("================= message = {}", gson.toJson(message));
        kafkaTemplate.send("test-topic", gson.toJson(message));
    }
}
