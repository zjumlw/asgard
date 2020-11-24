package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-12 11:11 下午
 * @Version 1.0
 */
public class Problem922 {

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int i = 0; // 偶数
        int j = 1; // 奇数
        while (i < len) {
            // 遇到偶数索引的数不是偶数
            if ((A[i] & 1) == 1) {
                // 寻找奇数索引的数不是奇数
                while ((A[j] & 1) == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
            i += 2;
        }
        return A;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Problem922 problem922 = new Problem922();
        int[] A = new int[]{4, 2, 5, 7};
        int[] ans = problem922.sortArrayByParityII(A);
        System.out.println(Arrays.toString(ans));
    }
}
