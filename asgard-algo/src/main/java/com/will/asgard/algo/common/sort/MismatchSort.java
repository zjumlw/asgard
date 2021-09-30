package com.will.asgard.algo.common.sort;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-20 3:43 下午
 * @Version 1.0
 **/
public class MismatchSort {

    public BigDecimal mismatchSort(int n) {
        if (n <= 2) {
            return n <= 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(n - 1);
        }

        BigDecimal[] dp = new BigDecimal[n + 1];
        dp[1] = BigDecimal.valueOf(0);
        dp[2] = BigDecimal.valueOf(1);
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1].add(dp[i - 2])).multiply(BigDecimal.valueOf(i - 1));
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " ==> " + dp[i]);
        }

        return dp[n];
    }
}
