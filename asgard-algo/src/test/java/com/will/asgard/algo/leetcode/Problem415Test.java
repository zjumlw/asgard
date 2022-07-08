package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-29 7:29 下午
 * @Version 1.0
 **/
public class Problem415Test {

    private Problem415 problem415 = new Problem415();

    @Test
    public void test1_1() {
        String a = "456";
        String b = "77";
        String s = problem415.addStrings(a, b);
        System.out.println(s);
    }
}