package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-26 下午8:35
 * @Version 1.0
 */
public class Problem1190Test {

    private Problem1190 problem1190;

    @Before
    public void setUp() throws Exception {
        problem1190 = new Problem1190();
    }

    @Test
    public void test() {
        String s = "(u(love)i)";
        String ans = problem1190.reverseParentheses(s);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        String s = "(u(love)i)";
        String ans = problem1190.reverseParenthesesV2(s);
        System.out.println(ans);
    }
}