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

    public static void main(String[] args) {
        Problem142 problem142 = new Problem142();
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        ListNode ans = problem142.detectCycle(head);
        System.out.println(ans.val);
    }
}
