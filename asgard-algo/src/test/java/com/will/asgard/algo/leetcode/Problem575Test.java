package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-01 5:35 下午
 * @Version 1.0
 **/
public class Problem575Test {

    private Problem575 problem575 = new Problem575();

    @Test
    public void test1_1() {
        int[] candies = {1, 1, 2, 2, 3, 3};
        int ans = problem575.distributeCandies(candies);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        int[] candies = {1, 1, 2, 3};
        int ans = problem575.distributeCandies(candies);
        System.out.println(ans);
    }
}