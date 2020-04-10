package com.will.asgard.loki.model.concurrent.chapter5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName SingletonTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-09 20:08
 * @Version 1.0
 **/
public class SingletonTest {

    @Test
    public void test() {
        Singleton singleton = Singleton.getInstance();
        singleton.setName("Jack");

        System.out.println(Singleton.getInstance().getName());
    }
}