package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-01 8:51 上午
 * @Version 1.0
 **/
public class Problem165Test {

    private Problem165 problem165 = new Problem165();

    @Test
    public void test1_1() {
        int ans = problem165.compareVersion("1.01", "1.001");
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test1_2() {
        int ans = problem165.compareVersion("1.0", "1.0.0");
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test1_3() {
        int ans = problem165.compareVersion("0.1", "1.1");
        Assert.assertEquals(-1, ans);
    }

    @Test
    public void test1_4() {
        int ans = problem165.compareVersion("1.0.1", "1");
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test1_5() {
        int ans = problem165.compareVersion("7.5.2.4", "7.5.3");
        Assert.assertEquals(-1, ans);
    }

    @Test
    public void testCalNum() {
        int ans = problem165.calcNum("1");
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        int ans = problem165.compareVersionV2("1.01", "1.001");
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test2_2() {
        int ans = problem165.compareVersionV2("1.0", "1.0.0");
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test2_3() {
        int ans = problem165.compareVersionV2("0.1", "1.1");
        Assert.assertEquals(-1, ans);
    }

    @Test
    public void test2_4() {
        int ans = problem165.compareVersionV2("1.0.1", "1");
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test2_5() {
        int ans = problem165.compareVersionV2("7.5.2.4", "7.5.3");
        Assert.assertEquals(-1, ans);
    }
}