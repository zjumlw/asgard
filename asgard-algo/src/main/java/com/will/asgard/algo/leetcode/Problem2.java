package com.will.asgard.algo.leetcode;

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

	@SuppressWarnings("Duplicates")
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode cursor = head;

		int flag = 0;
		while (l1 != null || l2 != null || flag!=0) {
			int sum = flag;
			int l1Value = l1 != null ? l1.val : 0;
			int l2Value = l2 != null ? l2.val : 0;
			sum = sum + l1Value + l2Value;

			cursor.next = new ListNode(sum % 10);
			cursor = cursor.next;
			flag = sum / 10;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNodeUtil.initList(new int[]{1});
		ListNode l2 = ListNodeUtil.initList(new int[]{9});
		ListNode result = new Problem2().addTwoNumbers(l1, l2);
		ListNodeUtil.printList(result);
	}
}
