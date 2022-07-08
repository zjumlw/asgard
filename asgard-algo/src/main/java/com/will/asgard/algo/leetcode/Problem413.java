package com.will.asgard.algo.leetcode;

/**
 * @Description 413. 等差数列划分 medium
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-08-10 10:27 下午
 * @Version 1.0
 **/
public class Problem413 {

    /**
     * 差分+计数
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        int d = nums[0] - nums[1];
        int t = 0;
        int ans = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i - 1] - nums[i] == d) {
                t++;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    /**
     * 双指针
     */
    public int numberOfArithmeticSlicesV2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; ) {
            int j = i;
            int d = nums[i + 1] - nums[i];
            while (j + 1 < n && nums[j + 1] - nums[j] == d) {
                j++;
            }
            int len = j - i + 1;
            int a1 = 1;
            int an = len - 3 + 1;
            int cnt = (a1 + an) * an / 2;
            ans += cnt;
            i = j;
        }
        return ans;
    }

    /**
     * 动态规划
     * dp[i] 表示：以 nums[i] 结尾的、且长度大于等于3的连续等差数列的个数
     * 如果 nums[i] 能够在 nums[i - 1]之后形成一个长度更长的等差数列，那么有：
     * dp[i] = dp[i - 1] + 1
     */
    public int numberOfArithmeticSlicesV3(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}