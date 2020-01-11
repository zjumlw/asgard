package com.will.asgard.common.core.leetcode;

/**
 * Add two numbers
 *
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 */
public class Problem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode point = res;

        int flag = 0;
        while (l1 != null || l2 != null) {


            int num = 0;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }

            if (flag == 1) {
                num += 1;
                flag = 0;
            }

            if (num >= 10) {
                flag = 1;
                num = num - 10;
            }

            point.next = new ListNode(num);
            if (flag == 1) {
                point.next.next = new ListNode(1);
            }
            point = point.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = createListNode(1);
        System.out.println("l1: " + showNumber(l1));

        ListNode l2 = createListNode(9);
        System.out.println("l2: " + showNumber(l2));

        ListNode result = new Problem2().addTwoNumbers(l1, l2);
        System.out.println("result: " + showNumber(result));
    }

    private static ListNode createListNode(int... array) {
        if (array.length == 0) {
            return null;
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        for (int value : array) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return result.next;
    }

    private static String showNumber(ListNode listNode) {
        if (listNode == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        ListNode curNode = listNode;
        sb.insert(0, curNode.val);
        while (curNode.next != null) {
            sb.insert(0, curNode.next.val);
            curNode = curNode.next;
        }

        return sb.toString();
    }
}
