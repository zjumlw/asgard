package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-01 00:39
 **/
public class Problem1475Test {

    private final Problem1475 problem1475 = new Problem1475();

    @Test
    public void test_1() {
        int[] prices = {8, 4, 6, 2, 3};
        int[] ans = problem1475.finalPrices(prices);
        System.out.println(Arrays.toString(ans));

        prices = new int[]{1, 2, 3, 4, 5};
        int[] ans2 = problem1475.finalPrices(prices);
        System.out.println(Arrays.toString(ans2));

        prices = new int[]{10, 1, 1, 6};
        int[] ans3 = problem1475.finalPrices(prices);
        System.out.println(Arrays.toString(ans3));
    }

    @Test
    public void test_2() {
        int[] prices = {8, 4, 6, 2, 3};
        int[] ans = problem1475.finalPricesV2(prices);
        System.out.println(Arrays.toString(ans));

        prices = new int[]{1, 2, 3, 4, 5};
        int[] ans2 = problem1475.finalPricesV2(prices);
        System.out.println(Arrays.toString(ans2));

        prices = new int[]{10, 1, 1, 6};
        int[] ans3 = problem1475.finalPricesV2(prices);
        System.out.println(Arrays.toString(ans3));
    }
}