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
    public List<User> selectUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUsers();
    }

    @Override
    public User getUser(String userId) {
        return null;
    }
}
