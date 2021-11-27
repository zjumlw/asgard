package com.will.asgard.algo.common.trie;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-11-25 1:08 上午
 * @Version 1.0
 **/
public class Trie {

    private class Node {
        public boolean isWord;
        public HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (curNode.next.get(c) == null) {
                curNode.next.put(c, new Node());
            }
            curNode = curNode.next.get(c);
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node curNode = root;
        Character c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (curNode.next.get(c) == null) {
                return false;
            }
            curNode = curNode.next.get(c);
        }
        return curNode.isWord;
    }

    public boolean isPrefix(String prefix) {
        Character c;
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (curNode.next.get(c) == null) {
                return false;
            }
            curNode = curNode.next.get(c);
        }
        return true;
    }
}
