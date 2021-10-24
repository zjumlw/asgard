package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-16 11:46 上午
 * @Version 1.0
 **/
public class Problem38Test {

    private Problem38 problem38 = new Problem38();

    @Test
    public void testCount() {
        String s = "111221";
        String ans = problem38.count(s);
        System.out.println(ans);
        Assert.assertEquals("312211", ans);
    }

    @Test
    public void test1_1() {
        String ans = problem38.countAndSay(5);
        Assert.assertEquals("111221", ans);
    }

    @Test
    public void test2_1() {
        String ans = problem38.countAndSayV2(5);
        Assert.assertEquals("111221", ans);
    }
}