package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2022-02-09 9:52 PM
 * @Version 1.0
 **/
public class Problem2006Test {

    private Problem2006 problem2006 = new Problem2006();

    @Test
    public void test1_1() {
        int[] nums = {1, 2, 2, 1};
        int ans = problem2006.countKDifference(nums, 1);
        System.out.println(ans);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test1_2() {
        int[] nums = {1, 3};
        int ans = problem2006.countKDifference(nums, 3);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test1_3() {
        int[] nums = {3, 2, 1, 5, 4};
        int ans = problem2006.countKDifference(nums, 2);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }
}