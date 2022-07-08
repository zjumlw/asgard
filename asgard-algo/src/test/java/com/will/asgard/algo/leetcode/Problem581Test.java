package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-13 10:41 下午
 * @Version 1.0
 **/
public class Problem581Test {

    private Problem581 problem581 = new Problem581();

    @Test
    public void test1_1() {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        int ans = problem581.findUnsortedSubarray(nums);
        System.out.println(ans);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test1_2() {
        int[] nums = new int[]{1, 2, 3, 4};
        int ans = problem581.findUnsortedSubarray(nums);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test1_3() {
        int[] nums = new int[]{1};
        int ans = problem581.findUnsortedSubarray(nums);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test2_1() {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        int ans = problem581.findUnsortedSubarrayV2(nums);
        System.out.println(ans);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test2_2() {
        int[] nums = new int[]{1, 2, 3, 4};
        int ans = problem581.findUnsortedSubarrayV2(nums);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test2_3() {
        int[] nums = new int[]{1};
        int ans = problem581.findUnsortedSubarrayV2(nums);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }
}