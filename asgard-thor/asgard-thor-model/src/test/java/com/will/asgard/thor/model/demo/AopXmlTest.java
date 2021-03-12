package com.will.asgard.thor.model.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.asgard.thor.model.demo.user.UserService;

/**
 * @Description 测试使用xml配置aop
 * @Author maolingwei
 * @Date 2021-03-10 下午11:24
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class AopXmlTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        userService.add();
    }
}