package com.will.asgard.thor.model.hello;

import java.net.URL;

import org.junit.Test;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-08-08 6:34 下午
 * @Version 1.0
 */
public class ClassPathTest {

    @Test
    public void testClassPath() {
        // 获取类加载的根路径
        String classPath1 = this.getClass().getResource("/").getPath();
        System.out.println(classPath1);

        // 获取当前类的所在工程路径
        String classPath2 = this.getClass().getResource("").getPath();
        System.out.println(classPath2);

        URL classPath3 = this.getClass().getClassLoader().getResource("");
        System.out.println(classPath3);

        // 当前工程路径
        String classPath4 = System.getProperty("user.dir");
        System.out.println(classPath4);

        // 获取所有的类路径 包括jar包的路径
        String classPath5 = System.getProperty("java.class.path");
        System.out.println(classPath5);
    }
}
