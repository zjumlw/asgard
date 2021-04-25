package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-21 下午11:27
 * @Version 1.0
 */
public class Problem21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        int[] data1 = new int[]{1, 2, 4};
        int[] data2 = new int[]{1, 3, 4};
        ListNode l1 = ListNodeUtil.initList(data1);
        ListNode l2 = ListNodeUtil.initList(data2);
        ListNode ans = problem21.mergeTwoLists(l1, l2);
        ListNodeUtil.printList(ans);
    }
}
