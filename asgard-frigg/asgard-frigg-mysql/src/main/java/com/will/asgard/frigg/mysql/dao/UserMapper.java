package com.will.asgard.frigg.mysql.dao;

import java.util.List;
import java.util.Map;

import com.will.asgard.frigg.model.User;

/**
 * @Description 使用xml配置开发
 *  resources/mapper/userMapper.xml
 * @Author maolingwei
 * @Date 2021-03-13 上午12:36
 * @Version 1.0
 */
public interface UserMapper {

    List<User> getUserList();

    User getUserById(long id);

    List<User> getUsersByLimit(Map<String, Integer> map);

    List<User> getUserLike(String key);

    long addUser(User user);

    // 利用map来传递参数
    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    // 利用map来更新用户
    int updateUser2(Map<String, Object> map);

    int deleteUser(long id);
}
