package com.example.demo.repository.mysql;

import com.example.demo.entity.mysql.MySQLBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: qizonghao
 * @Date: 2019-11-19
 * @Desc:
 */
public interface MySQLBlogRepository extends JpaRepository<MySQLBlog, Integer> {

    @Query("select e from MySQLBlog e order by e.createTime desc")
    List<MySQLBlog> queryAll();

    @Query("select e from MySQLBlog e where e.title like concat('%', :keyword, '%') or e.content like concat('%', :keyword, '%') ")
    List<MySQLBlog> queryBlogs(@Param("keyword") String keyword);
}
