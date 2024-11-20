package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-28 9:31 下午
 * @Version 1.0
 **/
public class Problem438Test {

    private Problem438 problem438 = new Problem438();

    @Test
    public void test1_1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = problem438.findAnagrams(s, p);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = problem438.findAnagramsV2(s, p);
        System.out.println(ans);
    }

    @Test
    public void test3_1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = problem438.findAnagramsV3(s, p);
        System.out.println(ans);
    }
}