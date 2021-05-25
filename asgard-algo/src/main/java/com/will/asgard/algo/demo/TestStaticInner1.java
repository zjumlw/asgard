package com.will.asgard.algo.demo;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description 一旦内部类使用static修饰，那么此时这个内部类就升级为顶级类
 * @Author maolingwei
 * @Date 2021-05-25 下午4:17
 * @Version 1.0
 */
public class TestStaticInner1 {

    // 可以直接创建内部类的对象，而不需要外部类的对象
    public static class Inner {
        // 静态内部类可以设置静态属性
        private static String name = "ZJ";

        private int number = 10;

        public static String getName() {
            return name;

        }

        public void print() {
            System.out.println("I am static inner 1");
        }

        public int getNumber() {
            return number;
        }

    }
}
