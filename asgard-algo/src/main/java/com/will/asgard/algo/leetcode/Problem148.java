package com.will.asgard.algo.leetcode;

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

    /**
     * 法1：自顶向下的归并排序
     *  1：找到链表的中点，拆分成两个子链表 2：对两个子链表分别排序 3：合并有序子链表
     * @param head 链表头节点
     * @return 排序后的链表
     */
    public ListNode sortList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        // 两个元素时，将head的next设置为null，这样就是一个元素，即单元素有序链表了
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = helper(head, mid);
        ListNode list2 = helper(mid, tail);
        return merge(list1, list2);
    }

    /**
     * 合并有序链表
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }

        if (p1 != null) {
            temp.next = p1;
        } else if (p2 != null) {
            temp.next = p2;
        }

        return dummy.next;
    }

    /**
     * 法2：自底向上的归并排序
     * 1：用subLength表示每次需要排序的子链表长度，初始subLength=1
     * 2：每次将链表拆成若干个长度为subLength的子链表，每两个子链表一组进行合并
     * 2：将subLength加倍，重复第二步，直到有序子链表的长度大于等于length
     */
    public ListNode sortListV2(ListNode head) {
        if (head == null) {
            return head;
        }

        // 先求出链表的长度length
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummy = new ListNode(-1, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null; // 设定下尾部

                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Problem148 problem148 = new Problem148();
        int[] data = new int[]{4, 2, 1, 3};
        ListNode head = ListNodeUtil.initList(data);
        ListNodeUtil.printList(head);

        ListNode ans = problem148.sortListV2(head);
        ListNodeUtil.printList(ans);

//        int[] d1 = new int[]{2, 4, 6};
//        int[] d2 = new int[]{1, 3, 5};
//        ListNode l1 = ListNodeUtil.initList(d1);
//        ListNode l2 = ListNodeUtil.initList(d2);
//        ListNode merge = problem148.merge(l1, l2);
//        ListNodeUtil.printList(merge);
    }
}
