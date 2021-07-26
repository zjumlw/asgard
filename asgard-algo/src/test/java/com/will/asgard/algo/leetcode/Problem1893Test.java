package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-23 11:18 下午
 * @Version 1.0
 **/
public class Problem1893Test {

    private Problem1893 problem1893 = new Problem1893();

    @Test
    public void test1() {
        int[][] ranges = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        boolean ans = problem1893.isCovered(ranges, 2, 5);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[][] ranges = new int[][]{{1, 10}, {10, 20}};
        boolean ans = problem1893.isCovered(ranges, 21, 21);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[][] ranges = new int[][]{{1, 50}};
        boolean ans = problem1893.isCovered(ranges, 1, 50);
        System.out.println(ans);
    }
}