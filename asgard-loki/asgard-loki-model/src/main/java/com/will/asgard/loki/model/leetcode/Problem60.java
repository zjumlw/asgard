package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-09-05 12:44 上午
 * @Version 1.0
 */
public class Problem60 {

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuilder sb = new StringBuilder();
        // 记录每一个元素是否被使用过，valid[0]不使用，所以要多一个长度
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);

        // 依次遍历确定每一个数字
        for (int i = 1; i <= n; i++) {
            // 确定当前数字在剩余所有未使用数字中的次序
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                // 定位到要使用的数字了
                if (order == 0) {
                    sb.append(j);
                    valid[j] = 0; // 标记该数字已被使用
                    break;
                }
            }
            // 确定一个数字之后，更新k
            k = k % factorial[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem60 problem60 = new Problem60();

        String permutation = problem60.getPermutation(3, 5);
        System.out.println(permutation);
    }
}
