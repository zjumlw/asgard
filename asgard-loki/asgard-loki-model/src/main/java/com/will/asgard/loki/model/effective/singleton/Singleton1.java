package com.will.asgard.loki.model.effective.singleton;

/**
 * @Description 饿汉式单例
 * @Author maolingwei
 * @Date 2020-07-25 6:37 下午
 * @Version 1.0
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
