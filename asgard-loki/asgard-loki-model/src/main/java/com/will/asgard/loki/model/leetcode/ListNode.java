package com.will.asgard.loki.model.leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
