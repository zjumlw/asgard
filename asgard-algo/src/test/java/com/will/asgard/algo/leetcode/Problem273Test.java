package com.will.asgard.algo.leetcode;

import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-11 7:59 下午
 * @Version 1.0
 **/
public class Problem273Test {

    private Problem273 problem273 = new Problem273();

    @Test
    public void test1_1() {
        String ans = problem273.numberToWords(123);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        String ans = problem273.numberToWords(12345);
        System.out.println(ans);
    }

    @Test
    public void test1_3() {
        String ans = problem273.numberToWords(1234567890);
        System.out.println(ans);
    }
}