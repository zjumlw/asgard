package com.will.asgard.algo.common.sort;


import com.will.asgard.algo.leetcode.ListNode;
import com.will.asgard.common.util.RandomUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-19 7:24 下午
 * @Version 1.0
 */
public class SortUtil {

    public static int[] generateRandomArray(int length) {
        return generateRandomArray(length, 100);
    }

    /**
     * 生成随机数组，指定数组长度和边界
     * @param length 数组长度
     * @param bound 边界，不能取到
     * @return 随机数组
     */
    public static int[] generateRandomArray(int length, int bound) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = RandomUtil.nextInt(bound);
        }
        return nums;
    }

    /**
     * 生成随机数组，指定数组的长度、最小值、最大值
     * @param length 数组长度
     * @param min 元素最小值，可以取到
     * @param max 元素最大值，可以取到
     * @return 随机数组
     */
    public static int[] generateRandomArray(int length, int min, int max) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = RandomUtil.betweenInt(min, max);
        }
        return nums;
    }

    /**
     * 交换数组中两个下标的元素
     * @param nums 数组
     * @param i 下标1
     * @param j 下标2
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static boolean isAscendingArray(int[] nums) {
        if (nums == null) {
            return false;
        }
        int length = nums.length;
        if (length == 1) {
            return true;
        }

        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscendingListNode(ListNode head) {
        if (head == null) {
            return false;
        }

        while (head.next != null) {
            if (head.val > head.next.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
