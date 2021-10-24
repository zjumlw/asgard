package com.will.asgard.algo.leetcode;

/**
 * @Description 476. 数字的补数 easy
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * 提示：
 * 1 <= num < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-10-20 8:21 下午
 * @Version 1.0
 **/
public class Problem476 {

    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        char[] arr = bin.toCharArray();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                arr[i] = '1';
            } else {
                arr[i] = '0';
            }
        }
        int ans = 0;
        int shift = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                ans += Math.pow(2, shift);
            }
            shift++;
        }

        return ans;
    }

    public int findComplementV2(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; i++) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }

    public int findComplementV3(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; i++) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < highbit; i++) {
            if (((num >> i) & 1) == 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
