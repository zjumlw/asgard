package com.will.asgard.loki.model.function;

import java.util.function.Function;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-08 下午8:14
 * @Version 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<Integer, Integer> function1 = integer -> integer * integer;
        // 2 * 2 = 4
        Integer ans1 = function1.apply(2);
        System.out.println(ans1);

        Function<Integer, Integer> function2 = function1.compose(integer -> integer + 1);
        // (3 + 1) * (3 + 1) = 16
        Integer ans2 = function2.apply(3);
        System.out.println(ans2);

        Function<Integer, Integer> function3 = function1.andThen(integer -> integer + 1);
        // 3 * 3 + 1 = 10
        Integer ans3 = function3.apply(3);
        System.out.println(ans3);
    }
}
