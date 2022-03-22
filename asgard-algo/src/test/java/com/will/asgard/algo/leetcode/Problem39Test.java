package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-12-13 11:16 下午
 * @Version 1.0
 **/
public class Problem39Test {

    private Problem39 problem39 = new Problem39();

    @Test
    public void test1_1() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = problem39.combinationSumV1(candidates, target);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = problem39.combinationSumV1(candidates, target);
        System.out.println(ans);
    }
}