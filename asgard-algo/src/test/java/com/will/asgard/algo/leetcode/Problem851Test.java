package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-12-15 10:30 下午
 * @Version 1.0
 **/
public class Problem851Test {

    private Problem851 problem851 = new Problem851();

    @Test
    public void test1_1() {
        int[][] richer = new int[][]{
                {1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}
        };
        int[] quiet = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
        int[] ans = problem851.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(ans));
    }
}