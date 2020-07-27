package com.will.asgard.loki.model.effective.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 懒汉式单例
 * @Author maolingwei
 * @Date 2020-07-25 6:39 下午
 * @Version 1.0
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2() {
    }
    public static Singleton2 getInstance() {
        if (instance == null) { // 读取instance的值
            instance = new Singleton2(); // 实例化instance
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": " + Singleton2.getInstance());
                }
            });
        }
        pool.shutdown();
    }
}
