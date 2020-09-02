package com.will.asgard.thor.service.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName AnnotationDemoMain
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-01 17:35
 * @Version 1.0
 **/
public class AnnotationDemoMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Starter starter = (Starter) context.getBean("starter");
        MyContext myContext = new MyContext();
        starter.start(myContext);

        System.out.println(GsonUtil.toJson(myContext.getMethodInvokeLink()));
    }
}
