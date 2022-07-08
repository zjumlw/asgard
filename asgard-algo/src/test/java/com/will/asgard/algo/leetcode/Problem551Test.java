package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-17 10:10 下午
 * @Version 1.0
 **/
public class Problem551Test {

    private Problem551 problem551 = new Problem551();

    @Test
    public void test1() {
        boolean ans = problem551.checkRecord("PPALLP");
        System.out.println(ans);
    }

    @Test
    public void test2() {
        boolean ans = problem551.checkRecord("LALL");
        System.out.println(ans);
    }
}