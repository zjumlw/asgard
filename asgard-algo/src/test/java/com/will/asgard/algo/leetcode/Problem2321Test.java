package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-04 2:13 下午
 * @Version 1.0
 **/
public class Problem2321Test {

    private Problem2321 problem2321 = new Problem2321();

    @Test
    public void test1_1() {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] ans = problem2321.smallestK(arr, 4);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_2() {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] ans = problem2321.smallestKV2(arr, 4);
        System.out.println(Arrays.toString(ans));
    }
}