package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 410. 分割数组的最大值 hard
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 示例 1：
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 *
 * 示例 3：
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 *
 * 提示：*
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10^6
 * 1 <= m <= min(50, nums.length)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-07-15 8:52 下午
 * @Version 1.0
 **/
public class Problem410 {

    /**
     * 二分查找
     * 如果有使最大值尽可能小，那么可以考虑一下二分查找的方法
     * 时间复杂度 O(N)，主要是遍历数组
     * 空间复杂度 O(1)
     */
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
//        System.out.println("sum=" + sum);
//        System.out.println("maxNum=" + maxNum);

        // 分割的子数组的和必须大于等于当前数组的元素最大值
        int left = maxNum;
        // 如果子数组的和等于sum，那么就是只分割成一组（就是没分割）
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int splits = split(nums, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 分割数组，使得子数组的和不大于target
     */
    private int split(int[] nums, int target) {
        // 至少可以分成一组
        int splits = 1;
        int sum = 0;
        for (int num : nums) {
            // 加上当前值还不大于target，可以加上
            if (sum + num <= target) {
                sum += num;
            } else { // 否则只能不采用num，进行分割
                splits++;
                sum = num;
            }
        }

        return splits;
    }

    /**
     * 动态规划
     * dp[i][k] 在前缀区间 [0, i]  被分成 k 段的各自的最大值的最小值
     * dp[i][k] = max(dp[j][k-1], rangeSum(j+1, i))  j < i
     * 时间复杂度 O(M*N^2)
     * 空间复杂度 O(N^2)
     */
    public int splitArrayV2(int[] nums, int m) {
        int len = nums.length;
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(preSum));

        int[][] dp = new int[len][m + 1];
        // 由于要找最小值，所以初值赋值成无法达到的最大值
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < len; i++) {
            dp[i][1] = preSum[i];
        }

        // 从分割数为 2 开始递推
        for (int k = 2; k <= m; k++) {
            for (int i = k - 1; i < len; i++) {
                for (int j = k - 2; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i] - preSum[j]));
                }
            }
        }

        return dp[len - 1][m];
    }
}
