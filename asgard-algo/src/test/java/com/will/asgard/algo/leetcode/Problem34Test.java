package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 5:20 下午
 * @Version 1.0
 **/
public class Problem34Test {

    private static Problem34 problem34;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem34 = new Problem34();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ans = problem34.searchRange(nums, 8);
        Assert.assertEquals(3, ans[0]);
        Assert.assertEquals(4, ans[1]);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ans = problem34.searchRange(nums, 6);
        Assert.assertEquals(-1, ans[0]);
        Assert.assertEquals(-1, ans[1]);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{};
        int[] ans = problem34.searchRange(nums, 0);
        Assert.assertEquals(-1, ans[0]);
        Assert.assertEquals(-1, ans[1]);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1};
        int[] ans = problem34.searchRange(nums, 1);
        Assert.assertEquals(0, ans[0]);
        Assert.assertEquals(0, ans[1]);
    }
}