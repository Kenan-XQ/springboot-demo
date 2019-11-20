package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: qizonghao
 * @Date: 2019-11-20
 * @Desc:
 */
@Data
public class Message {

    private Long id;
    private String msg;
    private Date sendTime;
}
