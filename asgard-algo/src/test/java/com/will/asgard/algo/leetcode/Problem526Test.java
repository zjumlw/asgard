package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-16 10:27 下午
 * @Version 1.0
 **/
public class Problem526Test {

    private Problem526 problem526 = new Problem526();

    @Test
    public void test1_1() {
        int ans = problem526.countArrangement(5);
        System.out.println(ans);
        Assert.assertEquals(10, ans);
    }

    @Test
    public void test2_1() {
        int ans = problem526.countArrangementV2(5);
        System.out.println(ans);
        Assert.assertEquals(10, ans);
    }

    @Test
    public void test3_1() {
        int ans = problem526.countArrangementV3(5);
        System.out.println(ans);
        Assert.assertEquals(10, ans);
    }
}