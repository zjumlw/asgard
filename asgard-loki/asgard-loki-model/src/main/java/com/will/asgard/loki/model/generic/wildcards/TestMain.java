package com.will.asgard.loki.model.generic.wildcards;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-20 18:27
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        // 协变
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new GreenApple();

        try {
            // 编译时认为时Fruit[]，但是运行时发现实际类型时Apple[]
            fruits[2] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fruits[3] = new Banana();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
