package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-19 10:18 下午
 * @Version 1.0
 **/
public class Problem345Test {

    private Problem345 problem345 = new Problem345();

    @Test
    public void test1_1() {
        String ans = problem345.reverseVowels("hello");
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        String ans = problem345.reverseVowels("leetcode");
        System.out.println(ans);
    }

    @Test
    public void test1_3() {
        String ans = problem345.reverseVowels(".,");
        System.out.println(ans);
    }
}