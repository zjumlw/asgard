package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-03 11:36 上午
 * @Version 1.0
 **/
public class Problem474Test {

    private static Problem474 problem474;
    private static String[] strs;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem474 = new Problem474();
        strs = new String[]{"10", "0001", "111001", "1", "0"};
    }

    @Test
    public void test1() {
        int ans = problem474.findMaxForm(strs, 5, 3);
        System.out.println(ans);
    }
}