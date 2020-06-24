package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-24 11:19 下午
 * @Version 1.0
 */
public class Problem16 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minGap = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int pb = i + 1;
            int pc = nums.length - 1;

            while (pb < pc) {
                int sum = a + nums[pb] + nums[pc];
                if (Math.abs(sum - target) <= minGap) {
                    minGap = Math.abs(sum - target);
                    result = sum;
                }

                if (sum > target) {
                    pc--;
                } else if (sum < target) {
                    pb++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 0};
        int closest = threeSumClosest(nums, -100);
        System.out.println(closest);
    }
}
