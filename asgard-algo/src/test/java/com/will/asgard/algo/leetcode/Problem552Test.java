package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-18 9:36 下午
 * @Version 1.0
 **/
public class Problem552Test {

    private Problem552 problem552 = new Problem552();

    @Test
    public void test1_1() {
        int ans = problem552.checkRecord(2);
        Assert.assertEquals(8, ans);
    }

    @Test
    public void test1_2() {
        int ans = problem552.checkRecord(1);
        Assert.assertEquals(3, ans);
    }

    @Ignore // 超时
    @Test
    public void test1_3() {
        // 超时
        int ans = problem552.checkRecord(10101);
        Assert.assertEquals(183236316, ans);
    }

    @Test
    public void test2_1() {
        int ans = problem552.checkRecordV2(2);
        Assert.assertEquals(8, ans);
    }

    @Test
    public void test2_2() {
        int ans = problem552.checkRecordV2(1);
        Assert.assertEquals(3, ans);
    }

    @Ignore // 超时
    @Test
    public void test2_3() {
        // 超时
        int ans = problem552.checkRecordV2(10101);
        Assert.assertEquals(183236316, ans);
    }

    @Test
    public void test3_1() {
        int ans = problem552.checkRecord_dp(2);
        Assert.assertEquals(8, ans);
    }

    @Test
    public void test3_2() {
        int ans = problem552.checkRecord_dp(1);
        Assert.assertEquals(3, ans);
    }

//    @Ignore // 超时
    @Test
    public void test3_3() {
        // 超时
        int ans = problem552.checkRecord_dp(10101);
        Assert.assertEquals(183236316, ans);
    }
}