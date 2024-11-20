package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-15 5:32 下午
 * @Version 1.0
 **/
public class Problem1846Test {

    private Problem1846 problem1846 = new Problem1846();

    @Test
    public void test1() {
        int[] arr = new int[]{2, 2, 1, 2, 1};
        int ans = problem1846.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(ans);
    }
}