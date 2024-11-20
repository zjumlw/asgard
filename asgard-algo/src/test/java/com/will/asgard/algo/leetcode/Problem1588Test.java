package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-29 10:31 下午
 * @Version 1.0
 **/
public class Problem1588Test {

    private Problem1588 problem1588 = new Problem1588();

    @Test
    public void test1_1() {
        int[] arr = {1, 4, 2, 5, 3};
        int ans = problem1588.sumOddLengthSubarrays(arr);
        System.out.println(ans);
        Assert.assertEquals(58, ans);
    }

    @Test
    public void test1_2() {
        int[] arr = {1, 2};
        int ans = problem1588.sumOddLengthSubarrays(arr);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_3() {
        int[] arr = {10, 11, 12};
        int ans = problem1588.sumOddLengthSubarrays(arr);
        System.out.println(ans);
        Assert.assertEquals(66, ans);
    }
}