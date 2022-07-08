package com.will.asgard.algo.leetcode;

/**
 * @Description 326. 3的幂 easy
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *  
 *
 * 进阶：
 *
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-09-23 9:22 下午
 * @Version 1.0
 **/
public class Problem326 {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        long a = 1;
        while(a <= n) {
            if (a == n) {
                return true;
            }
            a *= 3;
        }
        return false;
    }

    public boolean isPowerOfThreeV2(int n) {
        if (n <= 0) {
            return false;
        }
        // 是不是3的倍数
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeV3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
