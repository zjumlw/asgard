package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-20 9:58 下午
 * @Version 1.0
 **/
public class Problem1877Test {

    private Problem1877 problem1877 = new Problem1877();

    @Test
    public void test1() {
        int[] nums = new int[]{3, 5, 2, 3};
        int ans = problem1877.minPairSum(nums);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{3, 5, 4, 2, 4, 6};
        int ans = problem1877.minPairSum(nums);
        System.out.println(ans);
    }
}