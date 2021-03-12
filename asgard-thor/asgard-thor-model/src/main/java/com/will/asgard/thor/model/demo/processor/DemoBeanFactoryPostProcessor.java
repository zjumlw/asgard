package com.will.asgard.thor.model.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午9:39
 * @Version 1.0
 */
//@Component
public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("userService");
        Class<?> beanClass = bd.getBeanClass();
        System.out.println("beanClass=" + beanClass);
    }
}
