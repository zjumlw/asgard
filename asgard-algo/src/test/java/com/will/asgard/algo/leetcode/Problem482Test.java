package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-04 10:52 下午
 * @Version 1.0
 **/
public class Problem482Test {

    private Problem482 problem482 = new Problem482();

    @Test
    public void test1_1() {
        String s = "5F3Z-2e-9-w";
        String ans = problem482.licenseKeyFormatting(s, 4);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        String s = "2-5g-3-J";
        String ans = problem482.licenseKeyFormatting(s, 2);
        System.out.println(ans);
    }
}