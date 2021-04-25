package com.will.asgard.algo.common.list;

/**
 * @ClassName DeleteNode
 * @Description p237
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * @Auther maolingwei
 * @Date 2020-05-09 18:47
 * @Version 1.0
 **/
public class DeleteNode {
    private class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        // 然后删除掉后一个结点
        node.next = node.next.next;
    }
}
