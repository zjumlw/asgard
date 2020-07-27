package com.will.asgard.loki.model.effective.singleton;

import java.lang.reflect.Constructor;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Singleton
 * @Description 静态内部类实现单例
 * @Auther maolingwei
 * @Date 2020-01-21 17:03
 * @Version 1.0
 **/
public class Singleton {
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    @Getter
    @Setter
    private String name;

    private Singleton() {
        this.name = "singleton";
    }

    public static void main(String[] args) throws Exception {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("正常两个单例是否相同：" + (singleton1 == singleton2));

        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton3 = constructor.newInstance();
        System.out.println("反射攻击下单例是否相同：" + (singleton1 == singleton3));
    }
}
