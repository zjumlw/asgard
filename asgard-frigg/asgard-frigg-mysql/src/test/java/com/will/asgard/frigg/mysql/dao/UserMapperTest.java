package com.will.asgard.frigg.mysql.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.will.asgard.common.util.GsonUtil;
import com.will.asgard.frigg.model.User;
import com.will.asgard.frigg.mysql.utils.MyBatisUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-13 上午12:44
 * @Version 1.0
 */
@Slf4j
public class UserMapperTest {

    @Test
    public void test() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            // 方式一，推荐
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            System.out.println(GsonUtil.toJson(userList));

            // 方式二，不推荐
            List<User> userList1 = sqlSession.selectList("com.will.asgard.frigg.mysql.dao.UserMapper.getUserList");
            System.out.println(GsonUtil.toJson(userList1));
        }
    }

    @Test
    public void testGetUserById() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);

            // 这一次使用了sqlSession的缓存
            User user2 = mapper.getUserById(1);
            System.out.println(user == user2);

            // 更新user，会清除缓存
            User updateUser = new User();
            updateUser.setId(2);
            updateUser.setName("user3");
            updateUser.setPwd("pwd");
            int updated = mapper.updateUser(updateUser);
            System.out.println("updated=" + updated);

            // 从数据库获取
            User user3 = mapper.getUserById(1);
            System.out.println(user == user3);
        }
    }

    @Test
    public void testGetUserLike() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUserLike("%o%"); // 模糊查询
            System.out.println(GsonUtil.toJson(users));
        }
    }

    @Test
    public void testAddUser() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User newUser = new User();
            newUser.setName("新人");
            newUser.setPwd("xinren");
            long added = mapper.addUser(newUser);
            System.out.println(added);
            // 自动生成的id已经set到newUser对象的id中了
            System.out.println(GsonUtil.toJson(newUser));
            // 提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void testAddUser2() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("userName", "laoli");
            map.put("password", "laoli");

            int added = mapper.addUser2(map);
            System.out.println(added);

            // 提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setId(6);
            user.setName("haha");
            user.setPwd("hehe");

            int updated = mapper.updateUser(user);
            System.out.println("updated=" + updated);

            // 提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            int updated = mapper.deleteUser(7);
            System.out.println("updated=" + updated);

            // 提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void testGetUsersByLimit() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex", 2);
            map.put("pageSize", 2);
            List<User> users = mapper.getUsersByLimit(map);
            System.out.println(GsonUtil.toJson(users));

            // 提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void testCache() {
        SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.getUserById(1);
        System.out.println(user1);
        // 关闭会话，数据保存到二级缓存
        sqlSession1.close();

        // 新的会话
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println("equals=" + (user1 == user2));
    }
}