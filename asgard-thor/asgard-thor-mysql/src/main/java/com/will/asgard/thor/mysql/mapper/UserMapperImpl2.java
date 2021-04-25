package com.will.asgard.thor.mysql.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.will.asgard.thor.model.demo.user.User;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-18 下午6:13
 * @Version 1.0
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getAllUsers() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        List<User> users = mapper.getAllUsers();
        mapper.deleteUser(100);
        return users;
    }

    @Override
    public User getUserById(long userId) {
        return getSqlSession().getMapper(UserMapper.class).getUserById(userId);
    }

    @Override
    public long addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public long updateUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).updateUser(user);
    }

    @Override
    public int deleteUser(long userId) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(userId);
    }
}
