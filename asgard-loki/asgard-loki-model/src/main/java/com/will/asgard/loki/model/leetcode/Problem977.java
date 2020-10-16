package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-16 12:12 上午
 * @Version 1.0
 */
public class Problem977 {

    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] ans = new int[length];
        int left = 0;
        int right = length - 1;
        int idx = length - 1;
        while (left <= right) {
            if (A[left] * A[left] > A[right] * A[right]) {
                ans[idx--] = A[left] * A[left];
                left++;
            } else {
                ans[idx--] = A[right] * A[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem977 problem977 = new Problem977();
//        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        int[] ans = problem977.sortedSquares(nums);
        System.out.println(Arrays.toString(ans));
    }

}
