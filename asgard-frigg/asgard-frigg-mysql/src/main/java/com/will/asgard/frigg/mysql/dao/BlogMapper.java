package com.will.asgard.frigg.mysql.dao;

import java.util.List;
import java.util.Map;

import com.will.asgard.frigg.model.Blog;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-18 下午3:36
 * @Version 1.0
 */
public interface BlogMapper {

    long addBlog(Blog blog);

    List<Blog> queryBlogIf(Map<String, String> map);

    List<Blog> queryBlogChoose(Map<String, String> map);

    long updateBlog(Blog blog);

    List<Blog> queryBlogByIds(List<Long> ids);
}
