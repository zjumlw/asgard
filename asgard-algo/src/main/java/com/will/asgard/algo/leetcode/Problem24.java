package com.will.asgard.algo.leetcode;

import com.will.asgard.algo.leetcode.ListNode;
import com.will.asgard.algo.leetcode.ListNodeUtil;

/**
 * @Description
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-25 9:15 下午
 * @Version 1.0
 */
public class Problem24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next.next = swapPairs(head.next.next);
        ListNode tmp = head.next;
        head.next = tmp.next;
        tmp.next = head;
        return tmp;
    }

    public static ListNode swapPairsV2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNodeUtil.initList(arr);
        ListNodeUtil.printList(head);
        head = swapPairsV2(head);
        ListNodeUtil.printList(head);
    }

}
