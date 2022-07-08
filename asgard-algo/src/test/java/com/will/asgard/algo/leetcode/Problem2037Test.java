package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-04 4:28 下午
 * @Version 1.0
 **/
public class Problem2037Test {

    private Problem2037 problem2037 = new Problem2037();

    @Test
    public void test1_1() {
        int ans = problem2037.fib(48);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        int ans = problem2037.fibV2(48);
        System.out.println(ans);
    }

    @Test
    public void test1_3() {
        int ans = problem2037.fib_matrix(48);
        System.out.println(ans);
    }

}