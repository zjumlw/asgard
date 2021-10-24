package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-08 8:01 下午
 * @Version 1.0
 **/
public class Problem187Test {

    private Problem187 problem187 = new Problem187();

    @Test
    public void test1_1() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> ans = problem187.findRepeatedDnaSequences(s);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        String s = "AAAAAAAAAAA";
        List<String> ans = problem187.findRepeatedDnaSequences(s);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> ans = problem187.findRepeatedDnaSequencesV2(s);
        System.out.println(ans);
    }
}