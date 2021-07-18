package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-17 5:39 下午
 * @Version 1.0
 **/
public class Problem53Test {

    private Problem53 problem53 = new Problem53();

    @Test
    public void test1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = problem53.maxSubArray(nums);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = problem53.maxSubArrayV2(nums);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = problem53.maxSubArrayV3(nums);
        System.out.println(ans);
    }
}