package com.will.asgard.loki.model.function;

import java.util.function.BiFunction;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-08 下午8:34
 * @Version 1.0
 */
public class BiFunctionTest {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> function1 = Integer::sum;
        // 1 + 2
        Integer ans1 = function1.apply(1, 2);
        System.out.println(ans1);

        BiFunction<Integer, Integer, Integer> function2 = function1.andThen(integer -> integer * integer);
        // (1 + 2) * (1 + 2) = 9
        Integer ans2 = function2.apply(1, 2);
        System.out.println(ans2);
    }
}
