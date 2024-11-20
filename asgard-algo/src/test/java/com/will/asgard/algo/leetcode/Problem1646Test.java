package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-23 8:51 下午
 * @Version 1.0
 **/
public class Problem1646Test {

    private Problem1646 problem1646 = new Problem1646();

    @Test
    public void test1_1() {
        int ans = problem1646.getMaximumGenerated(7);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_2() {
        int ans = problem1646.getMaximumGenerated(2);
        System.out.println(ans);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test1_3() {
        int ans = problem1646.getMaximumGenerated(3);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }
}