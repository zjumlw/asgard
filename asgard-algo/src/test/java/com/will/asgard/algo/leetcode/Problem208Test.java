package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-11-25 3:56 下午
 * @Version 1.0
 **/
public class Problem208Test {

    private Problem208 problem208 = new Problem208();

    @Test
    public void test1_1() {
        Problem208.Trie trie = problem208.new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}