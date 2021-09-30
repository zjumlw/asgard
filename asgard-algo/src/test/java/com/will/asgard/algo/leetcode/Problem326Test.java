package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-23 9:23 下午
 * @Version 1.0
 **/
public class Problem326Test {

    private Problem326 problem326 = new Problem326();

    @Test
    public void test1_1() {
        boolean ans = problem326.isPowerOfThree(2147483647);
        System.out.println(ans);
    }
}