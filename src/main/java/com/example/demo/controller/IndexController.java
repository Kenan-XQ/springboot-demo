package com.example.demo.controller;

import com.example.demo.entity.mysql.MySQLBlog;
import com.example.demo.repository.mysql.MySQLBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: qizonghao
 * @Date: 2019-11-19
 * @Desc:
 */
@Controller
public class IndexController {

    @Autowired
    private MySQLBlogRepository mySQLBlogRepository;

    @RequestMapping("/index")
    public String index() {
        List<MySQLBlog> all = mySQLBlogRepository.findAll();
        System.out.println(all.size());
        return "index";
    }
}
