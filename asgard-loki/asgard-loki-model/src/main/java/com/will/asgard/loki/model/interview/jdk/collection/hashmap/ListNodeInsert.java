package com.will.asgard.loki.model.interview.jdk.collection.hashmap;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-06-25 10:29 下午
 * @Version 1.0
 */
public class ListNodeInsert {

    private class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }

    public <T> void headInsert(ListNode<T> head, ListNode<T> node) {
        node.next = head;
        head = node;
    }
}
