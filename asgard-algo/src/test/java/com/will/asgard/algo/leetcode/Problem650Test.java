package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-20 5:38 下午
 * @Version 1.0
 **/
public class Problem650Test {

    private Problem650 problem650 = new Problem650();

    @Test
    public void test1_1() {
        int ans = problem650.minSteps(100);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        int ans = problem650.minSteps(9973);
        System.out.println(ans);
        Assert.assertEquals(9973, ans);
    }

    @Test
    public void test1_3() {
        int ans = problem650.minSteps(20);
        System.out.println(ans);
        Assert.assertEquals(9, ans);
    }

}