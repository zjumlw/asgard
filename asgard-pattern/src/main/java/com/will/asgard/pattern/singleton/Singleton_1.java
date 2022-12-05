package com.will.asgard.pattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉式
 *  好处：大的单例对象创建耗费资源，也不一定使用，懒加载可以减少资源浪费。
 *  缺点：不是线程安全。
 * @author zjumlw
 * @date 2021-11-26 4:44 下午
 **/
public class Singleton_1 {

    private Singleton_1() { // 构造器私有
    }

    private static Singleton_1 instance = null;

    /**
     * 运行时创建单例，会有线程安全问题。
     *
     * @return 单例对象
     */
    public static Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }

    private final AtomicInteger count = new AtomicInteger(1);

    public void func() {
        System.out.println("count: " + count.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> Singleton_1.getInstance().func()).start();
        }
        // 最后 count 可能不为 10000
    }
}
