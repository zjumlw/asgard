package com.will.asgard.thor.mysql.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.will.asgard.thor.model.demo.user.User;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-12 上午9:44
 * @Version 1.0
 */
public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getAllUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getAllUsers();
    }

    @Override
    public User getUserById(long userId) {
        return sqlSession.getMapper(UserMapper.class).getUserById(userId);
    }

    @Override
    public long addUser(User user) {
        return sqlSession.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public long updateUser(User user) {
        return sqlSession.getMapper(UserMapper.class).updateUser(user);
    }

    @Override
    public int deleteUser(long userId) {
        return sqlSession.getMapper(UserMapper.class).deleteUser(userId);
    }
}
