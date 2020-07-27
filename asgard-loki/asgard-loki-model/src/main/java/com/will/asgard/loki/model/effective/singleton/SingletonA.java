package com.will.asgard.loki.model.effective.singleton;

import java.lang.reflect.Constructor;

/**
 * @ClassName SingletonA
 * @Description 单元素枚举的单例实现
 * @Auther maolingwei
 * @Date 2020-01-21 17:05
 * @Version 1.0
 **/
public enum SingletonA {
    INSTANCE;

    public static void main(String[] args) throws Exception {
        SingletonA singleton1 = SingletonA.INSTANCE;
        SingletonA singleton2 = SingletonA.INSTANCE;
        System.out.println("两个单例是否相同：" + (singleton1 == singleton2));

        Constructor<SingletonA> constructor = SingletonA.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonA singleton3 = constructor.newInstance();
        System.out.println("反射攻击下，是否相同" + (singleton1 == singleton3));
    }
}
