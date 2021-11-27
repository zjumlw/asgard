package com.will.asgard.algo.leetcode;

/**
 * @Description 260. 只出现一次的数字 III medium
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 *
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 *
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 *
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-10-30 10:29 下午
 * @Version 1.0
 **/
public class Problem260 {

    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }

        int l = 1;
        while ((x & 1) == 0) {
            x >>= 1;
            l <<= 1;
        }

        int x1 = 0;
        int x2 = 0;
        for (int num : nums) {
            if ((num & l) != 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        return new int[]{x1, x2};
    }
}
