package com.example.demo.controller;

import com.example.demo.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: qizonghao
 * @Date: 2019-11-20
 * @Desc:
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaSender kafkaSender;

    @RequestMapping("/send")
    public String send() {
        for (int i=1; i<=3; i++) {
            kafkaSender.send("this is " + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return "error send";
            }
        }
        return "success send";
    }
}
