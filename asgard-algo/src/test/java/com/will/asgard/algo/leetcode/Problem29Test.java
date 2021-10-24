package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-12 4:54 下午
 * @Version 1.0
 **/
public class Problem29Test {

    private Problem29 problem29 = new Problem29();


    @Test
    public void test1_1() {
        int ans = problem29.divide(10, 3);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_2() {
        int ans = problem29.divide(7, -3);
        System.out.println(ans);
        Assert.assertEquals(-2, ans);
    }

    @Test
    public void test1_3() {
        int ans = problem29.divide(-2147483648, -1);
        System.out.println(ans);
        Assert.assertEquals(2147483647L, ans);
    }

    @Test
    public void test1_4() {
        int ans = problem29.divide(-1, 1);
        System.out.println(ans);
        Assert.assertEquals(-1, ans);
    }

    @Test
    public void test1_5() {
        int ans = problem29.divide(-2147483648, -1);
        System.out.println(ans);
        Assert.assertEquals(2147483647L, ans);
    }

    @Test
    public void testMul() {
        int x = 3;
        int y = 11;
        long ans = problem29.mul(x, y);
        Assert.assertEquals(33, ans);
    }
}