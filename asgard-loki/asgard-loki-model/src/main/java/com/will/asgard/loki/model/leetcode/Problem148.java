package com.will.asgard.loki.model.leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @Description Medium
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-21 下午11:04
 * @Version 1.0
 */
public class Problem148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode cur = head;
        while (cur != null) {
            queue.offer(cur);
            cur = cur.next;
        }
        Iterator<ListNode> it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().val);
        }
        return head;
    }

    public static void main(String[] args) {
        Problem148 problem148 = new Problem148();
        int[] data = new int[]{4, 2, 1, 3};
        ListNode head = ListNodeUtil.initList(data);
        ListNodeUtil.printList(head);

        ListNode ans = problem148.sortList(head);
        ListNodeUtil.printList(ans);
    }
}
