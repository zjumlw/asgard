package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description medium 动态规划 贪心 二分查找
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：
 *
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-03-05 下午5:20
 * @Version 1.0
 */
public class Problem300 {

    /**
     * 动态规划，dp[i]由dp[j]而来，dp[i] = Math.max(dp[j]) + 1，0 <= j < i且num[j] < num[i]
     */
    public int lengthOfLIS(int[] nums) {
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
     * 贪心算法 + 二分
     */
    public int lengthOfLISV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] d = new int[length + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > d[len]) {
                len = len + 1;
                d[len] = nums[i];
            } else {
                int l = 1;
                int r = len;
                int pos = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Problem300 problem300 = new Problem300();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};

        int ans = problem300.lengthOfLIS(nums2);
        int ans2 = problem300.lengthOfLISV2(nums2);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
