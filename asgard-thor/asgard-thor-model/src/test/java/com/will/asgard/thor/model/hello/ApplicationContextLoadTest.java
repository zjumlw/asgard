package com.will.asgard.thor.model.hello;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description rt
 * @Author maolingwei
 * @Date 2020-08-08 6:43 下午
 * @Version 1.0
 */
public class ApplicationContextLoadTest {

    @Test
    public void testClassPathXmlApplicationContext1() {
        // classpath 路径下面
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
    }

    @Test
    public void testClassPathXmlApplicationContext2() {
        // classpath 路径下面，与上面相同
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beanFactoryTest.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
    }

    @Test
    public void testClassPathXmlApplicationContext3() {
        String xmlName = "beanFactoryTest.xml";
        String classPath = this.getClass().getResource("/").getPath();
        String xmlPath = classPath + xmlName;

        // 文件绝对路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:" + xmlPath);
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
    }

    @Test
    public void testFileSystemXmlApplicationContext1() {
        // classpath前缀
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "classpath:beanFactoryTest.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
    }

    @Test
    public void testFileSystemXmlApplicationContext2() {
        // 当前工程目录下
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "target/test-classes/beanFactoryTest.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
    }

    @Test
    public void testFileSystemXmlApplicationContext3() {
        String xmlName = "beanFactoryTest.xml";
        String classPath = this.getClass().getResource("/").getPath();
        String xmlPath = classPath + xmlName;

        // 文件绝对路径
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("file:" + xmlPath);
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        Assert.assertEquals("default", helloWorld.getMessage());
    }
}
