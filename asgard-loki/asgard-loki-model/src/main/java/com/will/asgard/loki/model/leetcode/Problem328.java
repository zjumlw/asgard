package com.will.asgard.loki.model.leetcode;

/**
 * @Description medium
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-13 10:44 下午
 * @Version 1.0
 */
public class Problem328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddCur = head;
        ListNode evenHead = head.next;
        ListNode evenCur = evenHead;
        // odd 始终落后 even
        while (evenCur != null) {
            ListNode evenNext = evenCur.next;
            oddCur.next = evenNext;
            if (evenNext != null) {
                oddCur = oddCur.next;
            }

            if (evenNext != null) {
                evenCur.next = evenNext.next;
            } else {
                evenCur.next = null;
            }
            evenCur = evenCur.next;
        }
        // 连接
        oddCur.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Problem328 problem328 = new Problem328();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.initList(nums);
        ListNodeUtil.printList(head);

        ListNode ans = problem328.oddEvenList(head);
        ListNodeUtil.printList(ans);
    }
}
