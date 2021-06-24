package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-07 下午10:44
 * @Version 1.0
 */
public class Problem494Test {

    private Problem494 problem494;

    @Before
    public void setUp() throws Exception {
        problem494 = new Problem494();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int ans = problem494.findTargetSumWays(nums, target);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int ans = problem494.findTargetSumWaysV2(nums, target);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int ans = problem494.findTargetSumWaysV3(nums, target);
        System.out.println(ans);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int ans = problem494.findTargetSumWaysV4(nums, target);
        System.out.println(ans);
    }
}