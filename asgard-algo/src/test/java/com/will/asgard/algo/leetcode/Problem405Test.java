package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-09 10:16 下午
 * @Version 1.0
 **/
public class Problem405Test {

    private Problem405 problem405 = new Problem405();

    @Test
    public void test1_1() {
        String ans = problem405.toHex(26);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        String ans = problem405.toHexV2(26);
        System.out.println(ans);
    }
}