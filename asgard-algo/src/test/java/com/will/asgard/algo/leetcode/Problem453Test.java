package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-20 8:06 下午
 * @Version 1.0
 **/
public class Problem453Test {

    private Problem453 problem453 = new Problem453();

    @Test
    public void test1_1() {
        int[] nums = {1, 2, 3};
        int ans = problem453.minMoves(nums);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_2() {
        int[] nums = {1, 1, 1};
        int ans = problem453.minMoves(nums);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }
}