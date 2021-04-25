package com.will.asgard.thor.mysql.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.asgard.thor.model.demo.user.User;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-18 下午7:27
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class UserMapperImplTest {

//    private ApplicationContext applicationContext;
//
//    @Before
//    public void before() {
//        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//    }

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Test
    public void testGetUsers() {
        List<User> users = userMapper.getAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testGetUserById() {
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        user.setAge(20);
        long updated = userMapper.updateUser(user);
        System.out.println(updated);
    }
}