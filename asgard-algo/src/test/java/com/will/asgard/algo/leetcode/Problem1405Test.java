package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2022-02-07 10:59 PM
 * @Version 1.0
 **/
public class Problem1405Test {

    private Problem1405 problem1405 = new Problem1405();

    @Test
    public void test1_1() {
        String ans = problem1405.longestDiverseString(1, 1, 7);
        System.out.println(ans);
        Assert.assertEquals(8, ans.length());
    }

    @Test
    public void test1_2() {
        String ans = problem1405.longestDiverseString(7, 1, 0);
        System.out.println(ans);
        Assert.assertEquals(5, ans.length());
    }

    @Test
    public void test1_3() {
        String ans = problem1405.longestDiverseString(2, 2, 1);
        System.out.println(ans);
        Assert.assertEquals(5, ans.length());
    }
}