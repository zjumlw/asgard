package com.will.asgard.algo.leetcode;

/**
 * @Description 430. 扁平化多级双向链表 medium
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *
 *
 * 扁平化后的链表如下图：
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 如何表示测试用例中的多级链表？
 *
 * 以 示例 1 为例：
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 序列化其中的每一级之后：
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *  
 *
 * 提示：
 *
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author zjumlw
 * @Date 2021-09-24 9:34 下午
 * @Version 1.0
 **/
public class Problem430 {

    private static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node[] ans = helper(head);
        return ans[0];
    }

    private Node[] helper(Node head) {
        Node[] ans = new Node[2];
        ans[0] = head;
        Node curr = head;
        while (curr != null) {
            // 非null的结尾
            ans[1] = curr;
            if (curr.child != null) {
                Node next = curr.next;
                Node[] tmp = helper(curr.child);
                curr.child = null;

                curr.next = tmp[0];
                tmp[0].prev = curr;
                tmp[1].next = next;
                if (next != null) {
                    next.prev = tmp[1];
                }
            } else {
                curr = curr.next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Node head1 = test1();
        print(head1);

        // solution
        Problem430 problem430 = new Problem430();
        Node ans = problem430.flattenV2(head1);
        print(ans);
    }

    private static Node test1() {
        // init
        int[] line1 = {1, 2, 3, 4, 5, 6};
        Node head1 = generate(line1);

        int[] line2 = {7, 8, 9, 10};
        Node head2 = generate(line2);
        head1.next.next.child = head2;

        int[] line3 = {11, 12};
        Node head3 = generate(line3);
        head2.next.child = head3;

        return head1;
    }

    private static Node test2() {
        int[] line1 = {1};
        Node head1 = generate(line1);
        int[] line2 = {2};
        Node head2 = generate(line2);
        head1.child = head2;
        int[] line3 = {3};
        Node head3 = generate(line3);
        head2.child = head3;
        return head1;
    }

    private static Node generate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node curr = head;
        Node prev = head;
        for (int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            curr.next = node;
            curr = node;
            curr.prev = prev;
            prev = curr;
        }
        return head;
    }

    private static final String SEPARATOR = "--";

    private static void print(Node head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        Node curr = head;
        Node parent = null;
        int blankCount = 0;

        StringBuilder sb = new StringBuilder();
        // 记录换行时的空格数量
        do {
            // 到下一行了
            if (parent != null) {
                curr = parent.child;
            }

            // 新的一行，重置下parent
            parent = null;

            while (curr != null) {
                if (curr.child != null) {
                    parent = curr;
                }
                // 没有找到parent，假如有下一行，则需要在前面补空格
                // 补的空格数量基于当前curr的数值位数和--分隔符
                if (parent == null) {
                    blankCount += calcBlankCount(curr.val);
                }
                sb.append(curr.val).append(SEPARATOR);
                curr = curr.next;
            }
            sb.append("NULL").append("\n");

            if (parent != null) {
                // 需要先加一下过渡行
                addBlanks(sb, blankCount);
                sb.append("|").append("\n");
                // 需要再加一下下一行的空格
                addBlanks(sb, blankCount);
            }

            // 如果有child，改变curr的指向，为拥有child的那个节点的
        } while (parent != null);

        System.out.println(sb);
    }

    private static int calcBlankCount(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt ++;
            num = num / 10;
        }
        return cnt + SEPARATOR.length();
    }

    private static void addBlanks(StringBuilder sb, int blankCount) {
        for (int i = 0; i < blankCount; i++) {
            sb.append(" ");
        }
    }

    public Node flattenV2(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;
        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                Node childLast = dfs(curr.child);

                curr.next = curr.child;
                curr.child.prev = curr;
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                curr.child = null;
                last = childLast;
            } else {
                last = curr;
            }
            curr = next;
        }
        return last;
    }
}
