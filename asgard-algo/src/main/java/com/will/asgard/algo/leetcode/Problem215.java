package com.will.asgard.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

import sun.tools.jconsole.inspector.Utils;

/**
 * @Description medium
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-06-10 下午11:27
 * @Version 1.0
 */
public class Problem215 {

    private Random random = new Random();

    public int findKthLargestV1(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int j = partitionV1(nums, left, right);
            if (j == target) {
                return nums[j];
            } else if (j < target) {
                left = j + 1;
            } else {
                right = j - 1;
            }
        }
    }

    private int partitionV1(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];

        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    public int findKthLargestV2(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int j = partitionV2(nums, left, right);
            if (j == target) {
                return nums[j];
            } else if (j < target) {
                left = j + 1;
            } else {
                right = j - 1;
            }
        }
    }

    private int partitionV2(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] <= pivot) {
                lt++;
            }
            while (gt >= left + 1 && nums[gt] >= pivot) {
                gt--;
            }
            if (lt > gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    public int findKthLargestV3(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int[] pIndex = partitionV3(nums, left, right);
            int index1 = pIndex[0];
            int index2 = pIndex[1];
            if (target < index1) {
                right = index1 - 1;
            } else if (target == index1) {
                return nums[index1];
            } else if (target < index2) {
                left = index1 + 1;
                right = index2 - 1;
            } else if (target == index2) {
                return nums[index2];
            } else {
                left = index2 + 1;
            }
        }
    }

    private int[] partitionV3(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);
        return new int[]{lt, gt - 1};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 最大堆 最小堆
     * 根据k的不同选择最大堆或者最小堆，如果k靠近0，则要选取较大的数，用最大堆；如果k靠近len，则要选取较小的数，用最小堆
     */
    public int findKthLargestV4(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}
