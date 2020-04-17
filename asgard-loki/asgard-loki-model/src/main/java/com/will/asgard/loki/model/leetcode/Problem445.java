package com.will.asgard.loki.model.leetcode;

import java.util.Stack;


/**
 * @ClassName Solution
 * @Description 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-04-14 23:52
 * @Version 1.0
 **/
public class Problem445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode head = new ListNode(-1);
        ListNode cursor = head;
        int flag = 0;
        while (r1 != null || r2 != null || flag != 0) {
            int tmp = flag;
            int r1Value = r1 != null ? r1.val : 0;
            int r2Value = r2 != null ? r2.val : 0;
            tmp = tmp + r1Value + r2Value;

            cursor.next = new ListNode(tmp % 10);
            cursor = cursor.next;
            flag = tmp / 10;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }

        return reverse(head.next);
    }

    private ListNode reverse(ListNode l) {
        ListNode res = null;
        while (l != null) {
            ListNode next = l.next;
            l.next = res;
            res = l;
            l = next;
        }
        return res;
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

    private static ListNode initList(int[] arr) {
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

    private static void printList(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            if (sb.length() != 0) {
                sb.append("->");
            }
            sb.append(l.val);
            l = l.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5,5};
        ListNode l1 = initList(arr1);

        int[] arr2 = new int[]{5,5};
        ListNode l2 = initList(arr2);

        ListNode added = new Problem445().addTwoNumbers(l1, l2);
        printList(added);
    }
}
