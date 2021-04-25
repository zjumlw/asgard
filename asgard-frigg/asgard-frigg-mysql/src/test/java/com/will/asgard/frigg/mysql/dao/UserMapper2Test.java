package com.will.asgard.frigg.mysql.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.will.asgard.common.util.GsonUtil;
import com.will.asgard.frigg.model.User;
import com.will.asgard.frigg.mysql.utils.MyBatisUtils;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-17 下午4:30
 * @Version 1.0
 */
public class UserMapper2Test {

    @Test
    public void testGetAllUsers() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        List<User> users = mapper.getAllUsers();
        System.out.println(GsonUtil.toJson(users));
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = mapper.getUserById(1);
        System.out.println(GsonUtil.toJson(user));
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setName("test2");
        user.setPwd("123");
        long added = mapper.addUser(user);
        System.out.println(added);
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setId(10);
        user.setName("test2");
        user.setPwd("123");
        long updated = mapper.updateUser(user);
        System.out.println(updated);
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        long deleted = mapper.deleteUser(9);
        System.out.println(deleted);
    }
}