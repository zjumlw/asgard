package com.will.asgard.loki.model.effective.singleton;

import java.lang.reflect.Constructor;

/**
 * @Description 双重检查加锁式单例
 * @Author maolingwei
 * @Date 2020-07-25 10:10 下午
 * @Version 1.0
 */
public class Singleton3 {
    private static volatile Singleton3 instance = null;
    private Singleton3() {
    }
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized(Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Singleton3 singleton3_1 = Singleton3.getInstance();
        Singleton3 singleton3_2 = Singleton3.getInstance();
        System.out.println("正常两个单例是否相同：" + (singleton3_1 == singleton3_2));

        Constructor<Singleton3> constructor = Singleton3.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton3 singleton3_3 = constructor.newInstance();
        System.out.println("反射攻击下单例是否相同：" + (singleton3_1 == singleton3_3));
    }
}
