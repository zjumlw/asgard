package com.will.asgard.loki.model.leetcode;

import java.util.*;

/**
 * @Description
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-25 12:08 上午
 * @Version 1.0
 */
public class Problem15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if (a > 0) { // 后面的数都大于0，不用再算了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // 遇到相同的数，不再算一次
                continue;
            }
            int pb = i + 1;
            int pc = nums.length - 1;
            while (pb < pc) {
//                System.out.println("i=" + i + ",pb=" + pb + ",pc=" + pc);
                int sum = a + nums[pb] + nums[pc];
                if (sum > 0) {
                    while(pb < pc && nums[pc] == nums[--pc]); // --pc并跳过所有重复的值
                } else if (sum < 0) {
                    while(pb < pc && nums[pb] == nums[++pb]); // ++pb并跳过所有重复的值
                } else {
                    result.add(new ArrayList<>(Arrays.asList(a, nums[pb], nums[pc])));
                    while(pb < pc && nums[pb] == nums[++pb]); // ++pb并跳过所有重复的值
                    while(pb < pc && nums[pc] == nums[--pc]); // --pc并跳过所有重复的值
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,0,2,2};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
