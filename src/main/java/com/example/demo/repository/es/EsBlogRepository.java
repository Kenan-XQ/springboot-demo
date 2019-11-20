package com.example.demo.repository.es;

import com.example.demo.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: qizonghao
 * @Date: 2019-11-19
 * @Desc:
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {
}
