package com.will.asgard.pattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 静态内部类形式
 *  理由jvm类加载的特点实现。
 *  优点：线程安全，懒加载
 *  缺点：不是抗反射
 *
 *  相对于 3 来说更加的简洁。
 *
 * @author zjumlw
 * @date 2021-11-26 5:00 下午
 **/
public class Singleton_4 {

    // 静态内部类，在第一次被调用时才会被加载
    private static class Holder {
        private static final Singleton_4 instance = new Singleton_4();
    }

    private Singleton_4() {
    }

    public static Singleton_4 getInstance() {
        return Holder.instance;
    }

    private final AtomicInteger count = new AtomicInteger(1);

    private void func() {
        System.out.println("count: " + count.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> Singleton_4.getInstance().func()).start();
        }
        // count 始终为 10000
    }
}
