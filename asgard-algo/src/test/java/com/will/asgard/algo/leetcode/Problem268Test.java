package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-11-06 11:26 上午
 * @Version 1.0
 **/
public class Problem268Test {

    private Problem268 problem268 = new Problem268();

    @Test
    public void test1_1() {
        int[] nums = new int[]{3, 0, 1};
        int ans = problem268.missingNumber(nums);
        System.out.println(ans);
    }
}