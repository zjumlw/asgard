package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-09 下午10:43
 * @Version 1.0
 */
public class Problem879Test {

    private Problem879 problem879;

    @Before
    public void setUp() throws Exception {
        problem879 = new Problem879();
    }

    @Test
    public void test() {
        int n = 5;
        int minProfit = 3;
        int[] group = new int[]{2, 2};
        int[] profit = new int[]{2, 3};
        int ans = problem879.profitableSchemes(n, minProfit, group, profit);
        System.out.println(ans);
    }
}