package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description medium
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-06-03 下午4:40
 * @Version 1.0
 */
public class Problem523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        // 计算前缀和
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
//        System.out.println(Arrays.toString(preSum));

        // 前缀和除以k的余数第一次出现的下标
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            int t = preSum[i] % k;
            if (map.containsKey(t)) {
                int prevIndex = map.get(t);
                if (i - prevIndex >= 2) {
//                    System.out.println("i=" + i + ", prevIndex=" + prevIndex);
                    return true;
                }
            } else {
                map.put(t, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem523 problem523 = new Problem523();
        int[] nums = new int[]{23, 2, 6, 4, 7};
        int k = 13;
        boolean ans = problem523.checkSubarraySum(nums, k);
        System.out.println(ans);
    }
}
