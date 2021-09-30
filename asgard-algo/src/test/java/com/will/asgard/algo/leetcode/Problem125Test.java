package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-29 11:39 下午
 * @Version 1.0
 **/
public class Problem125Test {

    private Problem125 problem125 = new Problem125();

    @Test
    public void test1_1() {
        String s = "A man, a plan, a canal: Panama";
        boolean ans = problem125.isPalindrome(s);
        Assert.assertTrue(ans);
    }

    @Test
    public void test1_2() {
        String s = "race a car";
        boolean ans = problem125.isPalindrome(s);
        Assert.assertFalse(ans);
    }
}