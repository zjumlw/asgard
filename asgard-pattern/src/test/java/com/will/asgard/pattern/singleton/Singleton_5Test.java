package com.will.asgard.pattern.singleton;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-26 5:09 下午
 * @Version 1.0
 **/
public class Singleton_5Test {

    @Test
    public void testReflection1() {
        try {
            /*
                java.lang.NoSuchMethodException: com.will.asgard.pattern.singleton.Singleton_5.<init>()
                枚举类没有无参构造方法
             */
            Constructor c = Singleton_5.class.getDeclaredConstructor();
            c.setAccessible(true);
            Singleton_5 instance = (Singleton_5) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReflection2() {
        try {
            /*
                枚举类调用父类的构造方法：<java/lang/Enum.<init> : (Ljava/lang/String;I)V>
             */
            Constructor c = Singleton_5.class.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            /*
                java.lang.IllegalArgumentException: Cannot reflectively create enum objects
                at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
                但是无法通过反射创建枚举
            */
            Singleton_5 instance = (Singleton_5) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}