package com.will.asgard.algo.leetcode;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-06-25 10:39 下午
 * @Version 1.0
 */
public class ListNodeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        ListNode head = ListNodeUtil.initList(arr);
        ListNodeUtil.printList(head);

        ListNode node = new ListNode(4);
        head = headInsert(head, node);
        ListNodeUtil.printList(head);
    }

    private static ListNode headInsert(ListNode head, ListNode node) {
        node.next = head;
        return node;
    }
}
