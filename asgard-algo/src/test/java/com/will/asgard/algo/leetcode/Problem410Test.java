package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-15 8:56 下午
 * @Version 1.0
 **/
public class Problem410Test {

    private Problem410 problem410 = new Problem410();

    @Test
    public void test1() {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        int ans = problem410.splitArray(nums, m);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        int ans = problem410.splitArrayV2(nums, m);
        System.out.println(ans);
    }
}