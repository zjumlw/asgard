package com.will.asgard.loki.model.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-26 6:34 下午
 * @Version 1.0
 */
public class Problem1591 {

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (set.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 2};
        ListNode head = ListNodeUtil.initList(nums);
        ListNodeUtil.printList(head);
        ListNode listNode = removeDuplicateNodes(head);
        ListNodeUtil.printList(listNode);
    }
}
