package com.will.asgard.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-11-25 3:03 下午
 * @Version 1.0
 **/
public class Problem208 {

    class Trie {
        // node
        class Node {
            boolean isWord;
            // 所有可能子节点的映射
            Map<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new HashMap<>();
            }

            public Node() {
                this(false);
            }
        }
        // node

        private Node root;
        private int size;

        public Trie() {
            root = new Node();
            size = 0;
        }

        public void insert(String word) {
            Node curNode = root;
            // 逐个字符遍历，加到字典树中
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                // 如果当前节点的 next map 没有c，则新建
                if (curNode.next.get(c) == null) {
                    curNode.next.put(c, new Node());
                }
                curNode = curNode.next.get(c);
            }
            // 到最后一个字符了，标记为一个word
            if (!curNode.isWord) {
                curNode.isWord = true;
                size++;
            }
        }

        public boolean search(String word) {
            Node curNode = root;
            Character c;
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                // 字符不在字典数上，没有这个字
                if (curNode.next.get(c) == null) {
                    return false;
                }
                curNode = curNode.next.get(c);
            }
            // 最后一个 node，看是否为 word
            return curNode.isWord;
        }

        public boolean startsWith(String prefix) {
            Character c;
            Node curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                c = prefix.charAt(i);
                // 字符不在字典数上，没有这个字
                if (curNode.next.get(c) == null) {
                    return false;
                }
                curNode = curNode.next.get(c);
            }
            return true;
        }
    }
}

