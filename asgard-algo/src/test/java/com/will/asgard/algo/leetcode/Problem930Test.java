package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 2:59 下午
 * @Version 1.0
 **/
public class Problem930Test {

    private static Problem930 problem930;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem930 = new Problem930();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        int ans = problem930.numSubarraysWithSum(nums, goal);
        System.out.println(ans);
    }

    @Test
    public void test1a() {
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        int ans = problem930.numSubarraysWithSumV2(nums, goal);
        System.out.println(ans);
    }

    @Test
    public void test1b() {
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        int ans = problem930.numSubarraysWithSumV3(nums, goal);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        int goal = 0;
        int ans = problem930.numSubarraysWithSum(nums, goal);
        System.out.println(ans);
    }

    @Test
    public void test2a() {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        int goal = 0;
        int ans = problem930.numSubarraysWithSumV2(nums, goal);
        System.out.println(ans);
    }

    @Test
    public void test2b() {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        int goal = 0;
        int ans = problem930.numSubarraysWithSumV3(nums, goal);
        System.out.println(ans);
    }
}