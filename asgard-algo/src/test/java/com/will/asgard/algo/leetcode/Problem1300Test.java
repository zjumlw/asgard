package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-20 11:14 下午
 * @Version 1.0
 **/
public class Problem1300Test {

    private Problem1300 problem1300 = new Problem1300();

    @Test
    public void test1() {
        int[] arr = new int[]{4, 9, 3};
        int ans = problem1300.findBestValue(arr, 10);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] arr = new int[]{2, 3, 5};
        int ans = problem1300.findBestValue(arr, 10);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] arr = new int[]{60864, 25176, 27249, 21296, 20204};
        int ans = problem1300.findBestValue(arr, 56803);
        System.out.println(ans);
    }
}