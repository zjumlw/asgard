package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-09 23:36
 **/
public class Problem1598Test {

    private Problem1598 problem1598 = new Problem1598();

    @Test
    public void test1_1() {
        String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        int ans = problem1598.minOperations(logs);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test1_2() {
        String[] logs = new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"};
        int ans = problem1598.minOperations(logs);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test1_3() {
        String[] logs = new String[]{"d1/", "../", "../", "../"};
        int ans = problem1598.minOperations(logs);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }
}