package com.will.asgard.frigg.mysql.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.will.asgard.frigg.model.Blog;
import com.will.asgard.frigg.mysql.utils.MyBatisUtils;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-18 下午3:43
 * @Version 1.0
 */
public class BlogMapperTest {

    @Test
    public void testAddBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setAuthor("laomao");
        blog.setTitle("boke1");
        blog.setCreateTime(new Date());
        blog.setViews(1000);
        mapper.addBlog(blog);
    }

    @Test
    public void testQueryBlogIf() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("title", "%boke%");
//        map.put("author", "laomao");
        List<Blog> blogs = mapper.queryBlogIf(map);
        blogs.forEach(System.out::println);
    }

    @Test
    public void testQueryBlogChoose() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
//        map.put("title", "%boke%");
//        map.put("author", "laomao");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        blogs.forEach(System.out::println);
    }

    @Test
    public void testUpdateBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("博客2");
        blog.setAuthor("laowei");
        long updated = mapper.updateBlog(blog);
        System.out.println(updated);
    }

    @Test
    public void testQueryBlogByIds() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(3L);

        List<Blog> blogs = mapper.queryBlogByIds(ids);
        blogs.forEach(System.out::println);
    }
}