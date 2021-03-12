package com.will.asgard.thor.model.demo.proxy;

import com.will.asgard.thor.model.demo.user.UserService;
import com.will.asgard.thor.model.demo.user.UserServiceImpl;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午10:30
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        // greet
        GreetImpl greet = new GreetImpl();
        pih.setTarget(greet);
        Greet proxy = (Greet) pih.getProxy();
        proxy.hello("jack");

        // userService
        UserServiceImpl userService = new UserServiceImpl();
        pih.setTarget(userService);
        UserService proxy1 = (UserService) pih.getProxy();
        proxy1.add();
    }
}
