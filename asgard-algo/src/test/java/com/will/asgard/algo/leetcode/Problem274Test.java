package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-11 11:08 上午
 * @Version 1.0
 **/
public class Problem274Test {

    private Problem274 problem274 = new Problem274();

    @Test
    public void test1() {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int ans = problem274.hIndex(citations);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int ans = problem274.hIndexV2(citations);
        System.out.println(ans);
    }
}