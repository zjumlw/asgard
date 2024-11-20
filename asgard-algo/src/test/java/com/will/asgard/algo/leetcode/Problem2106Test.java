package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-18 6:40 下午
 * @Version 1.0
 **/
public class Problem2106Test {

    private Problem2106 problem2106 = new Problem2106();

    @Test
    public void test1() {
        String[] strs = new String[]{"ate", "eat", "and", "tae", "nad", "bbq"};
        List<List<String>> ans = problem2106.groupAnagrams(strs);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        String[] strs = new String[]{"ate", "eat", "and", "tae", "nad", "bbq"};
        List<List<String>> ans = problem2106.groupAnagramsV2(strs);
        System.out.println(ans);
    }
}