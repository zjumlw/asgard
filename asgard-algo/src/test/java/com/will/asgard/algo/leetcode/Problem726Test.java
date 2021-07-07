package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-05 7:35 下午
 * @Version 1.0
 **/
public class Problem726Test {

    private static Problem726 problem726;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem726 = new Problem726();
    }

    @Test
    public void test1() {
        String formula = "H20";
        String ans = problem726.countOfAtoms(formula);
        System.out.println(ans);
    }
}