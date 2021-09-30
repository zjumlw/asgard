package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-08 9:38 下午
 * @Version 1.0
 **/
public class Problem502Test {

    private Problem502 problem502 = new Problem502();

    @Test
    public void test1_1() {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        int ans = problem502.findMaximizedCapital(2, 0, profits, capital);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test1_2() {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        int ans = problem502.findMaximizedCapital(3, 0, profits, capital);
        Assert.assertEquals(6, ans);
    }
}