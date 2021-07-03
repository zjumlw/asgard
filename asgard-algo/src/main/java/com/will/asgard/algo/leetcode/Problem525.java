package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description medium
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-07-03 10:12 上午
 * @Version 1.0
 **/
public class Problem525 {

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        // 子数组马上想到前缀和
        int[] preSum = new int[len];
        preSum[0] = nums[0] == 0 ? -1 : 1;
        for (int i = 1; i < len; i++) {
            int add = nums[i] == 0 ? -1 : 1;
            preSum[i] = preSum[i - 1] + add;
        }
        System.out.println(Arrays.toString(preSum));

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 1; i < preSum.length; i++) {
            int val = preSum[i];
            if (map.containsKey(val)) {
                int index = map.get(val);
                ans = Math.max(ans, i - index);
            } else {
                map.put(val, i);
            }
        }

        return ans;
    }
}
