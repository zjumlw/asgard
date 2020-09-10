package com.will.asgard.thor.model.hello;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-11 12:59 上午
 * @Version 1.0
 */
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextUtil.applicationContext == null) {
            System.out.println("applicationContext is initializing...");
            ApplicationContextUtil.applicationContext = applicationContext;
        } else {
            System.out.println("applicationContext is exist");
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            System.out.println("applicationContext is null");
            throw new IllegalStateException("application context is null");
        }
        return applicationContext.getBean(clazz);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
