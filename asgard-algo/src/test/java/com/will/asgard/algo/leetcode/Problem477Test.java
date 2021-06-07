package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-01 下午5:29
 * @Version 1.0
 */
public class Problem477Test {

    @Test
    public void test1() {
        Problem477 problem477 = new Problem477();
        int[] nums = new int[]{4, 12, 2};
        int ans = problem477.totalHammingDistance(nums);
        System.out.println(ans);
    }
}