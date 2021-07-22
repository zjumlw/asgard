package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-19 9:52 下午
 * @Version 1.0
 **/
public class Problem1838Test {

    private Problem1838 problem1838 = new Problem1838();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 4};
        int ans = problem1838.maxFrequency(nums, 5);
        System.out.println(ans);
    }
}