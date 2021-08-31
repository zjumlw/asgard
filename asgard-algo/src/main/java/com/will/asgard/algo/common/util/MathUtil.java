package com.will.asgard.algo.common.util;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-26 9:38 下午
 * @Version 1.0
 **/
public class MathUtil {

    public static long choose(int all, int part) {
        if (all < part) {
            throw new IllegalArgumentException();
        }

        long a = 1;
        int tmp = part;
        while (tmp > 0) {
            a *= all;
            all--;
            tmp--;
        }

        long b = fact(part);
        return a / b;
    }

    public static long fact(int num) {
        long ans = 1;
        for (int i = 1; i <= num; i++) {
            ans *= i;
        }
        return ans;
    }
}
