package com.will.asgard.algo.leetcode;

import java.util.PriorityQueue;

/**
 * 按照频率将数组生序排列 easy
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
 * 请你返回排序后的数组。
 *
 * 示例 1：
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 *
 * 示例 2：
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 *
 * 示例 3：
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-array-by-increasing-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author willmao
 * @date 2022-09-19 21:34
 **/
public class Problem1636 {

    public int[] frequencySort(int[] nums) {
        int[] cnt = new int[201];
        for (int num : nums) {
            cnt[num + 100]++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int diff1 = o1[1] - o2[1];
            if (diff1 != 0) {
                return diff1;
            } else {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                int[] data = new int[]{i - 100, cnt[i]};
                queue.offer(data);
            }
        }

        int n = nums.length;
        int[] ans = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int num = arr[0];
            int count = arr[1];
            while (count > 0) {
                ans[index] = num;
                count--;
                index++;
            }
        }
        return ans;
    }
}
