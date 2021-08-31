package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-09 5:52 下午
 * @Version 1.0
 **/
public class Problem1137Test {

    private Problem1137 problem1137 = new Problem1137();

    @Test
    public void test1() {
        int ans = problem1137.tribonacci(25);
        Assert.assertEquals(1389537, ans);
    }

    @Test
    public void test2() {
        int ans = problem1137.tribonacciV2(25);
        Assert.assertEquals(1389537, ans);
    }
}