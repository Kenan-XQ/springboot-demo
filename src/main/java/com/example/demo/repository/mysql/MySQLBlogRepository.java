package com.example.demo.repository.mysql;

import com.example.demo.entity.mysql.MySQLBlog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: qizonghao
 * @Date: 2019-11-19
 * @Desc:
 */
public interface MySQLBlogRepository extends JpaRepository<MySQLBlog, Integer> {
}
