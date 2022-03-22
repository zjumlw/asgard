package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 2006. 差的绝对值为 K 的数对数目 easy
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 *
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 *
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2022-02-09 9:23 PM
 * @Version 1.0
 **/
public class Problem2006 {

    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            List<Integer> i1 = map.getOrDefault(num + k, new ArrayList<>());
            ans += i1.size();

            List<Integer> i2 = map.getOrDefault(num - k, new ArrayList<>());
            ans += i2.size();

            List<Integer> curr = map.getOrDefault(num, new ArrayList<>());
            curr.add(j);
            map.put(num, curr);
        }
        return ans;
    }

    public int countKDifferenceV2(int[] nums, int k) {
        int[] cnts = new int[110];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t - k >= 1) {
                ans += cnts[t - k];
            }
            if (t + k <= 100) {
                ans += cnts[t + k];
            }
            cnts[t]++;
        }
        return ans;
    }
}
