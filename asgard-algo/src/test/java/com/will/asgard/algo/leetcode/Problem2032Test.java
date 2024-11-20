package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-29 10:48 下午
 * @Version 1.0
 **/
public class Problem2032Test {

    private Problem2032 problem2032 = new Problem2032();

    @Test
    public void test1_1() {
        int[] time = {1, 2, 3, 3};
        int ans = problem2032.minTime(time, 2);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_2() {
        int[] time = {99, 99, 99};
        int ans = problem2032.minTime(time, 4);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test1_3() {
        int[] time = {1, 2, 3, 4, 5, 6, 7, 9, 9, 9};
        int ans = problem2032.minTime(time, 3);
        System.out.println(ans);
        Assert.assertEquals(13, ans);
    }

}