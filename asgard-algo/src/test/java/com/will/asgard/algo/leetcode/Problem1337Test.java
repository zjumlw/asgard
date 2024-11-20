package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import com.will.asgard.algo.leetcode.util.ArrayUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-06 5:36 下午
 * @Version 1.0
 **/
public class Problem1337Test {

    private Problem1337 problem1337 = new Problem1337();

    @Test
    public void test1() {
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int[] ans = problem1337.kWeakestRows(mat, 3);
        int[] expected = new int[]{2, 0, 3};
        System.out.println(Arrays.toString(ans));
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, ans));
    }

    @Test
    public void test2() {
        int[][] mat = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        int[] ans = problem1337.kWeakestRows(mat, 2);
        int[] expected = new int[]{0, 2};
        System.out.println(Arrays.toString(ans));
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, ans));
    }
}