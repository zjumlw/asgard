package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-01 下午5:09
 * @Version 1.0
 */
public class Problem461Test {

    private Problem461 problem461;

    @Before
    public void setUp() throws Exception {
        problem461 = new Problem461();
    }

    @Test
    public void test1() {
        int x = 1;
        int y = 4;
        int ans = problem461.hammingDistance(x, y);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test2() {
        int x = 1;
        int y = 4;
        int ans = problem461.hammingDistanceV2(x, y);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test3() {
        int x = 1;
        int y = 4;
        int ans = problem461.hammingDistanceV3(x, y);
        Assert.assertEquals(2, ans);
    }
}