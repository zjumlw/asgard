package com.will.asgard.algo.common.sort;

import java.util.Deque;
import java.util.LinkedList;

import com.will.asgard.algo.leetcode.ArrayUtil;
import com.will.asgard.algo.leetcode.ListNode;
import com.will.asgard.algo.leetcode.ListNodeUtil;
import com.will.asgard.algo.leetcode.Node;

/**
 * @Description 了解
 * 冒泡排序：反复交换相邻的，但没有按照次序排列的元素，每一轮将一个「未排定部分」最大的元素「冒泡」到「未排定部分」的末尾，直至整个数组有序。
 * - 相邻的两个元素进行比较，把比较大的元素排在后面，这样遍历一轮下来，就可以找到这一轮循环中最大的那个元素，我们把这个过程形象地称之为「冒泡」；
 * - 由于每一轮循环都「冒泡」出一个这一轮循环最大的元素，所以上一轮循环的最后一个元素，不应该参加下一轮循环的比较了，这就是为什么内层循环的结束条
 *   件是 j < arr.length - i -1  的原因
 *
 * 时间复杂度： 平均O(n2) 最好O(n) --> 改善型的冒泡 最差O(n2)
 * 空间复杂度：O(1)
 * 原地排序
 * 稳定：因为每次比较后如果两个相邻元素相等我们并不会将他们交换，所以冒泡不会改变相同元素的下标，所以冒泡排序是一个稳定的排序
 *
 * @Author maolingwei
 * @Date 2020-09-19 8:53 下午
 * @Version 1.0
 */
public class BubbleSort {

    /**
     * 基础的冒泡排序，可能会超时
     */
    public void bubbleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化的冒泡排序，使用sorted来判断当前循环是否已经有序，如果已经有序，则退出循环，减少了循环次数
     */
    public void bubbleSortV2(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    sorted = false;
                }
            }
            // 本次循环没有交换，则停止
            if (sorted) {
                return;
            }
        }
    }

    /**
     * 在V2基础上的再次优化，记录最后一次交换的下标，减少循环的范围
     */
    public void bubbleSortV3(int[] nums) {
        if (nums == null) {
            return;
        }

        int len = nums.length;
        boolean swapped;
        int lastSwappedIndex = 0;
        int sortBorder = len - 1;
        for (int i = 0; i < len - 1; i++) {
            swapped = false;
            for (int j = 0; j < sortBorder; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtil.swap(nums, j, j + 1);
                    swapped = true;
                    lastSwappedIndex = j;
                }
            }

            sortBorder = lastSwappedIndex;
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 用递归实现冒泡排序
     * 干什么：实现一趟冒泡排序
     */
    public void bubbleSortV4(int[] nums, int n) {
        // 结束条件：数组只有一个元素
        if (n == 1) {
            return;
        }

        // 等价关系式：一趟冒泡排序
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                SortUtil.swap(nums, i, i + 1);
            }
        }
        // 下一趟的递归
        bubbleSortV4(nums, n - 1);
    }

    /**
     * 用双栈实现冒泡排序
     */
    public void bubbleSortV5(int[] nums) {
        if (nums == null) {
            return;
        }

        int length = nums.length;
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        for (int num : nums) {
            s1.push(num);
        }

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                while (!s1.isEmpty()) {
                    moveStackElement(s1, s2);
                }
                nums[length - 1 - i] = s2.pop();
            } else {
                while (!s2.isEmpty()) {
                    moveStackElement(s2, s1);
                }
                nums[length - 1 - i] = s1.pop();
            }
        }
    }

    private void moveStackElement(Deque<Integer> from, Deque<Integer> to) {
        int t = from.pop();
        if (to.isEmpty()) {
            to.push(t);
        } else {
            if (to.peek() > t) {
                int temp = to.pop();
                to.push(t);
                to.push(temp);
            } else {
                to.push(t);
            }
        }
    }

    /**
     * 链表的冒泡排序，交换节点值
     */
    public void bubbleSortListNode(ListNode head) {
        if (head == null) {
            return;
        }

        boolean swapped;
        ListNode ptr1;
        ListNode lptr = null;

        do {
            swapped = false;
            ptr1 = head;
            while (ptr1.next != lptr) {
                if (ptr1.val > ptr1.next.val) {
                    swapVal(ptr1, ptr1.next);
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            // 更新最后的指针
            lptr = ptr1;
        } while (swapped);
    }

    private void swapVal(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    /**
     * 链表的冒泡排序，交换节点
     * @param head
     */
    public ListNode bubbleSortListNodeV2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        boolean swapped;
        ListNode prev;
        ListNode cur;
        // 指向最后一个交换的节点
        ListNode lptr = null;

        do {
            swapped = false;
            // 重头节点开始遍历
            prev = dummy;
            cur = dummy.next;

            while (cur.next != lptr) {
                if (cur.val > cur.next.val) {
                    ListNode first = swapNode(cur, cur.next);
                    swapped = true;
                    prev.next = first;
                    prev = prev.next;
                } else {
                    prev = prev.next;
                    cur = cur.next;
                }
            }
            lptr = cur;
        } while (swapped);

        return dummy.next;
    }

    /**
     * 交换节点
     * @param first 第一个节点
     * @param second 第二个节点
     * @return 交换后的第一个节点
     */
    private ListNode swapNode(ListNode first, ListNode second) {
        ListNode third = second.next;
        second.next = first;
        first.next = third;
        return second;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = SortUtil.generateRandomArray(20);
        ArrayUtil.printArray(nums);

        bubbleSort.bubbleSortV2(nums);
        ArrayUtil.printArray(nums);
    }
}
