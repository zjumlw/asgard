package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-20 12:17 上午
 * @Version 1.0
 */
public class Problem143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int length = list.size();
        ListNode insert = null;
        for (int i = 0; i < length / 2; i++) {
            cur = list.get(i);

            if (insert != null) {
                insert.next = cur;
            }
            insert = list.get(length - 1 - i);
            insert.next = null;
            cur.next = insert;
        }
        if (length % 2 != 0 && insert != null) {
            ListNode last = list.get(length / 2);
            last.next = null;
            insert.next = last;
        }
    }

    public static void main(String[] args) {
        Problem143 problem143 = new Problem143();
        int[] data = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.initList(data);
        ListNodeUtil.printList(head);

        problem143.reorderList(head);
        ListNodeUtil.printList(head);
    }
}
