package com.will.asgard.algo.common.trie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-25 1:13 上午
 * @Version 1.0
 **/
public class TrieTest {

    @Test
    public void test1() {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("he");

        boolean ans1 = trie.contains("llo");
        System.out.println(ans1);
    }
}