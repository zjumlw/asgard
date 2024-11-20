package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-10 7:33 下午
 * @Version 1.0
 **/
public class Problem1894Test {

    private Problem1894 problem1894 = new Problem1894();

    @Test
    public void test1_1() {
        int[] chalk = {5, 1, 5};
        int ans = problem1894.chalkReplacer(chalk, 22);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test1_2() {
        int[] chalk = {3, 4, 1, 2};
        int ans = problem1894.chalkReplacer(chalk, 25);
        System.out.println(ans);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test1_3() {
        int[] chalk = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int ans = problem1894.chalkReplacer(chalk, 100);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }
}