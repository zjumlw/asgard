package com.will.asgard.thor.model.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.will.asgard.thor.model.demo.config.DemoConfig;
import com.will.asgard.thor.model.demo.user.UserService;
import com.will.asgard.thor.model.demo.user.UserServiceProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-03 下午8:42
 * @Version 1.0
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
        UserService userService = applicationContext.getBean("userServiceProxy", UserServiceProxy.class);
        userService.add();
    }
}
