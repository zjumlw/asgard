package com.will.asgard.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

import com.will.asgard.algo.leetcode.ListNode;

/**
 * LinkedList Cycle
 */
public class Problem141 {

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}

		return false;
	}

	public boolean hasCycleV2(ListNode head) {
		Set<ListNode> nodeSet = new HashSet<>();
		while (head != null) {
			if (nodeSet.contains(head)) {
				return true;
			} else {
				nodeSet.add(head);
			}

			head = head.next;
		}

		return false;
	}


}
