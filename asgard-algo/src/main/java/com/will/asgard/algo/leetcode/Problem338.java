package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description medium
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-03-03 下午2:03
 * @Version 1.0
 */
public class Problem338 {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            // 2的倍数
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            ans[i] = ans[i - highBit] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem338 problem338 = new Problem338();
        int num = 5;
        int[] ans = problem338.countBits(num);
        System.out.println(Arrays.toString(ans));
    }
}
