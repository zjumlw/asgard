package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-11-25 4:17 下午
 * @Version 1.0
 **/
public class Problem211Test {

    private Problem211 problem211 = new Problem211();

    @Test
    public void test1_1() {
        Problem211.WordDictionary obj = problem211.new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad")); // f
        System.out.println(obj.search("bad")); // t
        System.out.println(obj.search(".ad")); // t
        System.out.println(obj.search("b..")); // t
    }
}