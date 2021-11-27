package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-31 10:35 下午
 * @Version 1.0
 **/
public class Problem500Test {

    private Problem500 problem500 = new Problem500();

    @Test
    public void test1_1() {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] ans = problem500.findWords(words);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_2() {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] ans = problem500.findWordsV2(words);
        System.out.println(Arrays.toString(ans));
    }
}