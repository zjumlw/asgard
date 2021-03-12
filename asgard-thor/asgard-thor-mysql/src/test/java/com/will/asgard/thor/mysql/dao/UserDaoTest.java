package com.will.asgard.thor.mysql.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.will.asgard.common.util.GsonUtil;
import com.will.asgard.thor.model.demo.user.User;
import com.will.asgard.thor.mysql.mapper.UserMapper;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-11 上午12:33
 * @Version 1.0
 */
public class UserDaoTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 构建session的工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = ssf.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsers();
        System.out.println(GsonUtil.toJson(users));
    }

    @Test
    public void testMyBatisSpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.selectUsers();
        System.out.println(GsonUtil.toJson(users));
    }
}
