package com.example.demo.controller;

import com.example.demo.entity.es.EsBlog;
import com.example.demo.entity.mysql.MySQLBlog;
import com.example.demo.repository.es.EsBlogRepository;
import com.example.demo.repository.mysql.MySQLBlogRepository;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qizonghao
 * @Date: 2019-11-20
 * @Desc:
 */
@RestController
public class EsDataController {

    @Autowired
    private MySQLBlogRepository mySQLBlogRepository;
    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping("/blogs")
    public Object blog() {
        return mySQLBlogRepository.queryAll();
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param) {
        Map<String, Object> map = new HashMap<>(4);
        StopWatch watch = new StopWatch();
        watch.start();
        String type = param.getType();
        if (type.equals("mysql")) {
            // mysql
            List<MySQLBlog> mySQLBlogList = mySQLBlogRepository.queryBlogs(param.getKeyword());
            map.put("list", mySQLBlogList);
        } else if (type.equals("es")) {
            // es
//            POST /blog/_search
//            {
//                "query": {
//                    "bool": {
//                        "should": [
//                            {
//                                "match_phrase": {
//                                "title": "springboot"
//                            }
//                            },
//                            {
//                                "match_phrase": {
//                                "content": "spring"
//                            }
//                            }
//                        ]
//                    }
//                }
//            }
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            builder.should(QueryBuilders.matchPhraseQuery("title", param.getKeyword()));
            builder.should(QueryBuilders.matchPhraseQuery("content", param.getKeyword()));
            System.out.println(builder.toString());
            Page<EsBlog> search = (Page<EsBlog>) esBlogRepository.search(builder);
            List<EsBlog> list = search.getContent();
            map.put("list", list);
        } else {
            return "don't analysis";
        }
        watch.stop();
        long totalTimeMillis = watch.getTotalTimeMillis();
        map.put("duration", totalTimeMillis);
        return map;
    }

    @Data
    public static class Param {
        // mysql/es
        private String type;
        private String keyword;
    }
}
