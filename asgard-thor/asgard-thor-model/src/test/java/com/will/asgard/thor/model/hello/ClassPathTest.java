package com.will.asgard.thor.model.hello;

import java.net.URL;

import org.junit.Test;

/**
 * @Description 尽量使用URI形式的绝对路径资源。它可以很容易的转变为URI，URL，File对象
 *   尽量使用相对classpath的相对路径。不要使用绝对路径。
 *   绝对不要使用硬编码的绝对路径。因为，我们完全可以使用ClassLoader类的getResource（""）方法得到当前classpath的绝对路径。
 * @Author maolingwei
 * @Date 2020-08-08 6:34 下午
 * @Version 1.0
 */
public class ClassPathTest {

    @Test
    public void testClassPath() {
        // 当前类class文件的URI目录
        URL resource = this.getClass().getResource("");
        System.out.println(resource);

        // 当前ClassPath的绝对URI路径
        URL classPath1 = this.getClass().getResource("/");
        System.out.println(classPath1);
        // 当前ClassPath的绝对URI路径
        URL classPath2 = this.getClass().getClassLoader().getResource("");
        System.out.println(classPath2);
        // 当前ClassPath的绝对URI路径
        URL classPath3 = ClassLoader.getSystemResource("");
        System.out.println(classPath3);
        // 当前ClassPath的绝对URI路径
        URL classPath4 = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(classPath4);

        // 当前工程路径
        // 这是一颗定时炸弹，随时可能要你的命，尽量不要用
        String classPath10 = System.getProperty("user.dir");
        System.out.println(classPath10);

        // 获取所有的类路径 包括jar包的路径
        String classPath11 = System.getProperty("java.class.path");
        System.out.println(classPath11);
    }
}
