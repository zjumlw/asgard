package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-13 5:00 下午
 * @Version 1.0
 **/
public class Problem218Test {

    private Problem218 problem218 = new Problem218();

    @Test
    public void test1() {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> ans = problem218.getSkyline(buildings);
        System.out.println(ans);
    }
}