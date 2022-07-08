package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-20 9:57 下午
 * @Version 1.0
 **/
public class Problem476Test {

    private Problem476 problem476 = new Problem476();

    @Test
    public void test1_1() {
        int ans = problem476.findComplement(5);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test1_2() {
        int ans = problem476.findComplement(1);
        System.out.println(ans);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test2_1() {
        int ans = problem476.findComplementV2(5);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test3_1() {
        int ans = problem476.findComplementV3(5);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }
}