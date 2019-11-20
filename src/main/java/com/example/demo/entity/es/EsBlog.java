package com.example.demo.entity.es;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Author: qizonghao
 * @Date: 2019-11-19
 * @Desc:
 */
@Data
@Document(indexName = "blog", type = "doc", useServerConfiguration = true, createIndex = false)
@ToString
public class EsBlog {

    @Id
    private Integer id;  // 对应es中的id字段

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String title;
    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String author;
    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String content;
    @Field(type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date updateTime;
}
