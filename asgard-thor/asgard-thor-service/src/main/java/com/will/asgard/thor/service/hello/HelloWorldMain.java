package com.will.asgard.thor.service.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.will.asgard.thor.model.hello.ApplicationContextUtil;
import com.will.asgard.thor.model.hello.HelloWorld;

public class HelloWorldMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println("origin msg: " + helloWorld.getMessage());

        helloWorld.setMessage("Beijing");
        System.out.println("fixed msg: " + helloWorld.getMessage());

        HelloWorld helloWorld1 = ApplicationContextUtil.getBean(HelloWorld.class);
        System.out.println("second msg: " + helloWorld1.getMessage());

        ApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld2 = (HelloWorld) context2.getBean("helloWorld");
        System.out.println("third msg: " + helloWorld2.getMessage());

        System.out.println(ApplicationContextUtil.getBean(HelloWorld.class).getMessage());
    }
}
