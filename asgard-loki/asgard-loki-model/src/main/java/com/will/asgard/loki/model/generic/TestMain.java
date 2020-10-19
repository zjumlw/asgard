package com.will.asgard.loki.model.generic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-19 9:08 下午
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        // 不指定泛型
        Integer integer = TestMain.add(1, 2);
        Number number = TestMain.add(1, 1.2);
        Serializable serializable = TestMain.add(1, "abc");
        System.out.println(serializable);

        // 指定泛型
        Integer a = TestMain.<Integer>add(1, 2);
        String b = TestMain.<String>add("abc", "def");
        Number c = TestMain.<Number>add(1, 1.2);

        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        System.out.println(list);

        ArrayList list1 = new ArrayList<String>();
        list1.add(1);
        System.out.println(list1);

        boolean b1 = list instanceof ArrayList;
        System.out.println(b1);
//        boolean b2 = list instanceof ArrayList<String>; // 编译后 list 只剩下原始类型，泛型信息 String 不存在了
    }

    public static <T> T add(T x, T y) {
        return y;
    }
}
