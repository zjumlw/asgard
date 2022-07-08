package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-18 7:40 下午
 * @Version 1.0
 **/
public class Problem658Test {

    private Problem658 problem658 = new Problem658();

    @Test
    public void test1_1() {
        int[] arr = new int[]{1, 1, 1, 10, 10, 10};
        List<Integer> ans = problem658.findClosestElements(arr, 1, 10);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        int[] arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        List<Integer> ans = problem658.findClosestElements(arr, 3, 5);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        int[] arr = new int[]{1, 1, 1, 10, 10, 10};
        List<Integer> ans = problem658.findClosestElementsV2(arr, 1, 10);
        System.out.println(ans);
    }

    @Test
    public void test2_2() {
        int[] arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        List<Integer> ans = problem658.findClosestElementsV2(arr, 3, 5);
        System.out.println(ans);
    }
}