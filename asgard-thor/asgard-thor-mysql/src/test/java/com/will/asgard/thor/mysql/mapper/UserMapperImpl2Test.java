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
 * @Date 2021-03-18 下午6:14
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserMapperImpl2Test {

    @Autowired
    @Qualifier("userMapper2")
    private UserMapper userMapper;

    @Test
    public void testGetUsers() {
        List<User> users = userMapper.getAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("Tom");
        user.setAge(8);

        long added = userMapper.addUser(user);
        System.out.println(added);
    }
}