package com.will.asgard.pattern.singleton;

/**
 * @Description
 * 饿汉式
 *  优点：编译器就确定了单例对象，保证了线程安全。
 *  缺点：不是懒加载，会浪费资源。
 * @Author zjumlw
 * @Date 2021-11-26 4:51 下午
 * @Version 1.0
 **/
public class Singleton_2 {
    private Singleton_2() {
    }

    private static Singleton_2 instance = new Singleton_2();

    public static Singleton_2 getInstance() {
        return instance;
    }
}
