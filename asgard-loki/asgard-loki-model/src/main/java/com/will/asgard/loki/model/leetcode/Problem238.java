package com.will.asgard.loki.model.leetcode;

/**
 * @ClassName Problem238
 * @Description
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther maolingwei
 * @Date 2020-06-04 19:37
 * @Version 1.0
 **/
public class Problem238 {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }

        return res;
    }

    public static int[] solution(int[] nums) {
        int a = 1;
        int b = 1;
        int n = nums.length;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            output[i] *= a;
            a *= nums[i];

            output[n - 1 - i] *= b;
            b *= nums[n - 1 - i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] res = productExceptSelf(nums);
        ArrayUtil.printArray(res);

        int[] output = solution(nums);
        ArrayUtil.printArray(output);
    }
}
