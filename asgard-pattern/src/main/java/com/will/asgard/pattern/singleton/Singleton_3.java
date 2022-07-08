package com.will.asgard.pattern.singleton;

/**
 * @Description
 * 双重检查加锁式单例
 *  优点：懒加载，减少资源浪费；保证线程安全
 *  缺点：不能抗反射
 * @Author zjumlw
 * @Date 2021-11-26 4:53 下午
 * @Version 1.0
 **/
public class Singleton_3 {
    private Singleton_3() {
    }

    // 2. 所以这里加了 volatile 防止指令重排
    private volatile static Singleton_3 instance = null;

    public static Singleton_3 getInstance() {
        if (instance == null) {
            synchronized (Singleton_3.class) {
                if (instance == null) {
                    instance = new Singleton_3(); // 1. 指令可能会重排，导致等待的线程拿到null就返回了
                }
            }
        }
        return instance;
    }
}
