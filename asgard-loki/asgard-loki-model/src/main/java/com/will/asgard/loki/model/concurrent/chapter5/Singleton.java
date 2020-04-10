package com.will.asgard.loki.model.concurrent.chapter5;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Singleton
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-09 20:07
 * @Version 1.0
 **/
public class Singleton {
    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    @Getter
    @Setter
    private String name;
}
