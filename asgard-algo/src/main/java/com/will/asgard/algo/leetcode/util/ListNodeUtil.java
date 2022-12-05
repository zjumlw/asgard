package com.will.asgard.algo.leetcode.util;

import com.will.asgard.algo.leetcode.ListNode;

/**
 * ListNodeUtil
 *
 * @date 2020-04-17 14:45
 **/
public class ListNodeUtil {

    private ListNodeUtil() {
        throw new IllegalStateException();
    }

    public static ListNode initList(int[] arr) {
        ListNode head = null;
        ListNode cursor = null;
        for (int value : arr) {
            ListNode newOne = new ListNode(value);
            if (cursor == null) {
                head = newOne;
                cursor = head;
            } else {
                cursor.next = newOne;
                cursor = cursor.next;
            }
        }

        return head;
    }

    public static void printList(ListNode l) {
        if (l == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (l != null) {
            if (sb.length() != 0) {
                sb.append("->");
            }
            sb.append(l.val);
            l = l.next;
        }
        System.out.println(sb);
    }
}
