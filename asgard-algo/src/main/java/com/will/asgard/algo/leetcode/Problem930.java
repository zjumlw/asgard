package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description medium
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 *
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 *
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-07-08 2:00 下午
 * @Version 1.0
 **/
public class Problem930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        System.out.println(Arrays.toString(preSum));
        // 所有num的和
        int sum = preSum[len];
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len; i >= 0; i--) {
            int val = preSum[i];
            int diff = goal + val;
            if (diff <= sum) {
                int cnt = map.getOrDefault(diff, 0);
                ans += cnt;
            }

            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return ans;
    }

    public int numSubarraysWithSumV2(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += cnt.getOrDefault(sum - goal, 0);
        }
        return ans;
    }

    /**
     * 滑动窗口来实现
     * left2 - left1 的一段连续区间都是满足条件的
     */
    public int numSubarraysWithSumV3(int[] nums, int goal) {
        int n = nums.length;
        int right = 0, left1 = 0, left2 = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ans += left2 - left1;
            right++;
        }

        return ans;
    }
}
