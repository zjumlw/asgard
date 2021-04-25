package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-20 12:57 上午
 * @Version 1.0
 */
public class Problem206 {

    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
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

    /**
     * 递归
     */
    public ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListV2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        Problem206 problem206 = new Problem206();
        int[] data = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.initList(data);
        ListNodeUtil.printList(head);

        ListNode ans = problem206.reverseList(head);
        ListNodeUtil.printList(ans);
    }
}
