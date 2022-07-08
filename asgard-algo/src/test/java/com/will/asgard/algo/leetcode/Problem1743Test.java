package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-26 7:28 下午
 * @Version 1.0
 **/
public class Problem1743Test {

    private Problem1743 problem1743 = new Problem1743();

    @Test
    public void test1() {
        int[][] in = new int[][]{{2, 1}, {3, 4}, {3, 2}};
        int[] ans = problem1743.restoreArray(in);
        System.out.println(Arrays.toString(ans));
    }
}