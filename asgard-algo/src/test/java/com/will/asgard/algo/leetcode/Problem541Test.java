package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-21 1:54 下午
 * @Version 1.0
 **/
public class Problem541Test {

    private Problem541 problem541 = new Problem541();

    @Test
    public void test1_1() {
        String ans = problem541.reverseStr("abcdefg", 2);
        System.out.println(ans);
        Assert.assertEquals("bacdfeg", ans);
    }

    @Test
    public void test1_2() {
        String ans = problem541.reverseStr("abcd", 2);
        System.out.println(ans);
        Assert.assertEquals("bacd", ans);
    }

    @Test
    public void test1_3() {
        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        String ans = problem541.reverseStr(s, 39);
        String expected = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";
        Assert.assertEquals(expected, ans);
    }
}