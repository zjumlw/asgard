package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 11:27 下午
 * @Version 1.0
 **/
public class Problem153Test {

    private Problem153 problem153 = new Problem153();

    @Test
    public void test1() {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int ans = problem153.findMin(nums);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int ans = problem153.findMin(nums);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{11, 13, 15, 17};
        int ans = problem153.findMin(nums);
        Assert.assertEquals(11, ans);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{2, 1};
        int ans = problem153.findMin(nums);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test5() {
        int[] nums = new int[]{2, 3, 1};
        int ans = problem153.findMin(nums);
        System.out.println(ans);
        Assert.assertEquals(1, ans);
    }
}