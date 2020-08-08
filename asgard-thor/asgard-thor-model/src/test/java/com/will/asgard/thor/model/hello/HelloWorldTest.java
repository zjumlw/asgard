package com.will.asgard.thor.model.hello;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description rt
 * @Author maolingwei
 * @Date 2020-08-08 6:08 下午
 * @Version 1.0
 */
@SuppressWarnings("deprecation")
public class HelloWorldTest {

    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        HelloWorld helloWorld = (HelloWorld) bf.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
        helloWorld.setMessage("hello");
        Assert.assertEquals("hello", helloWorld.getMessage());
    }
}