package com.will.asgard.algo.leetcode;

/**
 * @Description 453. 最小操作次数使数组元素相等 easy
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -109 <= nums[i] <= 10^9
 * 答案保证符合 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-10-20 7:39 下午
 * @Version 1.0
 **/
public class Problem453 {

    /**
     * 使 n - 1 个元素加一，反向思维就是使 1 个元素减一
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }

        return ans;
    }
}
