package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-19 21:47
 **/
public class Problem1636Test {

    private Problem1636 problem1636 = new Problem1636();

    @Test
    public void test1_1() {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
        int[] ans = problem1636.frequencySort(nums);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_2() {
        int[] nums = new int[]{2, 3, 1, 3, 2};
        int[] ans = problem1636.frequencySort(nums);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_3() {
        int[] nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] ans = problem1636.frequencySort(nums);
        System.out.println(Arrays.toString(ans));
    }
}