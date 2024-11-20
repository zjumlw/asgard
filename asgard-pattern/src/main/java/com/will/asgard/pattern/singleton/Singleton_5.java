package com.will.asgard.pattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 枚举类型实现单例
 *  优点：线程安全，抗反射
 *  缺点：无法懒加载
 *
 * 注意点：枚举类型的字节码反编译<init>调用的是父类 <java/lang/Enum.<init> : (Ljava/lang/String;I)V> 构造方法，
 *  那么我们可以通过改变反射的构造器方法来实现破坏吗？
 *  不能。
 *
 * @author zjumlw
 * @date 2021-11-26 5:02 下午
 **/
public enum Singleton_5 {
    instance;

    private final AtomicInteger count = new AtomicInteger(1);

    private void func() {
        System.out.println("count: " + count.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(Singleton_5.instance::func).start();
        }
        // count 始终为 10000
    }
}
