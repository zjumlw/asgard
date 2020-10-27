package com.will.asgard.loki.model.leetcode;

/**
 * @Description
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-25 9:24 下午
 * @Version 1.0
 */
public class Problem845 {

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int len = A.length;
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(left[i] + right[i] + 1, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem845 problem845 = new Problem845();
        int[] a = new int[]{2, 1, 4, 7, 3, 2, 5};
        int ans = problem845.longestMountain(a);
        System.out.println(ans);
    }

}
