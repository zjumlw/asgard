package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 1713. 得到子序列的最少操作次数 hard
 * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。
 * 你可以在数组最开始或最后面添加整数。
 * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。
 * 比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 *
 * 示例 1：
 * 输入：target = [5,1,3], arr = [9,4,2,3,4]
 * 输出：2
 * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 *
 * 示例 2：
 * 输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * 输出：3
 *
 * 提示：
 * 1 <= target.length, arr.length <= 10^5
 * 1 <= target[i], arr[i] <= 10^9
 * target 不包含任何重复元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-07-26 8:04 下午
 * @Version 1.0
 **/
public class Problem1713 {

    public int minOperations(int[] target, int[] arr) {
        // 映射元素和下标位置，因为每个元素都是唯一的，所以下标也是唯一的
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }

        // 将arr数组每个元素中，如果属于target元素，则将其在target中的下标列出来
        List<Integer> l = new ArrayList<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                l.add(map.get(num));
            }
        }
        int m = l.size();
        int[] arrIndexes = new int[m];
        for (int i = 0; i < m; i++) {
            arrIndexes[i] = l.get(i);
        }

        // 求 arrIndexes 的最大递增子数组的长度
        int max = lengthOfLIS_binary(arrIndexes);
//        System.out.println("max=" + max);
        return target.length - max;
    }

    // 会超时
    private int lengthOfLIS_dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 如果已经得到的上升子序列的结尾的数越小，那么遍历后面的数时，就有更大的可能得到更长的上升子序列
     * tail[i]表示：长度为 i + 1 的所有上升子序列的结尾的最小值
     * tail[i]是一个严格上升数组
     * tail[i]的长度就是最长上升子序列的长度
     */
    private int lengthOfLIS_binary(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] tail = new int[n];
        tail[0] = nums[0];
        // 表示 tail 数组的最后一个被赋值元素的索引
        int endIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > tail[endIndex]) {
                tail[++endIndex] = nums[i];
            } else {
                int left = 0;
                int right = endIndex;
                // 找到第一个大于nums[i]的数
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] <= nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }

        return endIndex + 1;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(++i);
    }
}
