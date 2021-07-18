package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-11 10:31 上午
 * @Version 1.0
 **/
public class Problem275Test {

    private Problem275 problem275 = new Problem275();

    @Test
    public void test1() {
        int[] citations = new int[]{0, 1, 3, 5, 6};
        int ans = problem275.hIndex(citations);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2() {
        int[] citations = new int[]{0};
        int ans = problem275.hIndex(citations);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] citations = new int[]{11, 12};
        int ans = problem275.hIndex(citations);
        System.out.println(ans);
    }

    @Test
    public void test4() {
        int[] citations = new int[]{0, 0, 11, 12};
        int ans = problem275.hIndex(citations);
        System.out.println(ans);
    }
}