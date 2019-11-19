package com.example.demo.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: qizonghao
 * @Date: 2019-11-19
 * @Desc:
 */
@Data
@Table(name = "t_blog")
@Entity
public class MySQLBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private Date createTime;
    private Date updateTime;
}
