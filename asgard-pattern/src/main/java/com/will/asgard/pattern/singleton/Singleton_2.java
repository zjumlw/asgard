package com.will.asgard.pattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 饿汉式
 *  优点：编译器就确定了单例对象，保证了线程安全。
 *  缺点：不是懒加载，会浪费资源。
 * @author zjumlw
 * @date 2021-11-26 4:51 下午
 **/
public class Singleton_2 {
    private Singleton_2() {
    }

    private static Singleton_2 instance = new Singleton_2();

    public static Singleton_2 getInstance() {
        return instance;
    }

    private final AtomicInteger count = new AtomicInteger(1);

    private void func() {
        System.out.println("count: " + count.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> Singleton_2.getInstance().func()).start();
        }
        // count 始终为 10000
    }
}
