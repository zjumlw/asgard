package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-26 8:45 下午
 * @Version 1.0
 **/
public class Problem1713Test {

    private Problem1713 problem1713 = new Problem1713();

    @Test
    public void test1() {
        int[] target = new int[]{6, 4, 8, 1, 3, 2};
        int[] arr = new int[]{4, 7, 6, 2, 3, 8, 6, 1};
        int ans = problem1713.minOperations(target, arr);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2() {
        int[] target = new int[]{5, 1, 3};
        int[] arr = new int[]{9, 4, 2, 3, 4};
        int ans = problem1713.minOperations(target, arr);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test3() {
        int[] target = new int[]{1, 3, 8};
        int[] arr = new int[]{2, 6};
        int ans = problem1713.minOperations(target, arr);
        Assert.assertEquals(3, ans);
    }
}