package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-10 4:14 下午
 * @Version 1.0
 **/
public class Problem300Test {

    private Problem300 problem300 = new Problem300();

    @Test
    public void test1() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int ans = problem300.lengthOfLIS(nums);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 4, 8, 6, 12};
        int ans = problem300.lengthOfLISV2(nums);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{4, 10, 4, 3, 8, 9};
        int ans = problem300.lengthOfLISV2(nums);
        Assert.assertEquals(3, ans);
    }
}