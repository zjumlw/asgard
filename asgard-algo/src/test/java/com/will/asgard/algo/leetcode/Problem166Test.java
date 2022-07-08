package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-14 9:46 下午
 * @Version 1.0
 **/
public class Problem166Test {

    private Problem166 problem166 = new Problem166();

    @Test
    public void test1_1() {
        String ans = problem166.fractionToDecimal(1, 2);
        System.out.println(ans);
        Assert.assertEquals("0.5", ans);
    }

    @Test
    public void test1_2() {
        String ans = problem166.fractionToDecimal(4, 333);
        System.out.println(ans);
        Assert.assertEquals("0.(012)", ans);
    }

}