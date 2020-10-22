package com.will.asgard.loki.model.leetcode;

/**
 * @Description
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-23 2:27 上午
 * @Version 1.0
 */
public class Problem234 {

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 递归的方法
     */
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    /**
     * 快慢指针 反转链表
     */
    public boolean isPalindromeV2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow.next 是后半部分链表
        ListNode temp = reverseListNode(slow.next);
        ListNode rightHalf = temp;
        ListNode leftHalf = head;
        boolean ans = true;
        while (rightHalf != null) {
            if (leftHalf.val != rightHalf.val) {
                ans = false;
                break;
            } else {
                leftHalf = leftHalf.next;
                rightHalf = rightHalf.next;
            }
        }

        slow.next = reverseListNode(temp);
        return ans;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Problem234 problem234 = new Problem234();
        int[] data = new int[]{1, 2, 2, 2};
        ListNode head = ListNodeUtil.initList(data);

        boolean ans = problem234.isPalindrome(head);
        System.out.println(ans);

        boolean ans2 = problem234.isPalindromeV2(head);
        System.out.println(ans2);
    }
}
