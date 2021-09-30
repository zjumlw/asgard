package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-30 11:07 下午
 * @Version 1.0
 **/
public class Problem223Test {

    private Problem223 problem223 = new Problem223();

    @Test
    public void test1_1() {
        int ans = problem223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(ans);
    }
}