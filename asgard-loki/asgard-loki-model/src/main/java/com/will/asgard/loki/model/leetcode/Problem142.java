package com.will.asgard.loki.model.leetcode;

public class Problem142 {

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		boolean isLoop = false;
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				isLoop = true;
				break;
			}
		}

		if (isLoop) {
			slow = head;
			while (fast.next != null && fast.next.next != null) {
				if (slow == fast) {
					return slow;
				}

				slow = slow.next;
				fast = fast.next;
			}
		}

		return null;
	}

}
