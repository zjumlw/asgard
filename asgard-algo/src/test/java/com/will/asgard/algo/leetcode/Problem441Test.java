package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-10 3:29 下午
 * @Version 1.0
 **/
public class Problem441Test {

    private Problem441 problem441 = new Problem441();

    @Test
    public void test1_1() {
        int ans = problem441.arrangeCoins(5);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test1_2() {
        int ans = problem441.arrangeCoins(8);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_3() {
        int ans = problem441.arrangeCoins(1804289383);
        Assert.assertEquals(60070, ans);
    }

    @Test
    public void test2_1() {
        int ans = problem441.arrangeCoins_binary(5);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test2_2() {
        int ans = problem441.arrangeCoins_binary(8);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2_3() {
        int ans = problem441.arrangeCoins_binary(1804289383);
        Assert.assertEquals(60070, ans);
    }
}