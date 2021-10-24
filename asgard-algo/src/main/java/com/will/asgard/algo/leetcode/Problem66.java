package com.will.asgard.algo.leetcode;

/**
 * @Description 66. 加一 easy
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-10-21 4:37 下午
 * @Version 1.0
 **/
public class Problem66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] temp = new int[n];
        int carrier = 1;
        for (int i = n - 1; i >= 0; i--) {
            int num = digits[i] + carrier;
            temp[i] = num % 10;
            carrier = num / 10;
        }

        if (carrier == 0) {
            return temp;
        } else {
            int[] ans = new int[n + 1];
            ans[0] = 1;
//            System.arraycopy(temp, 0, ans, 1, n);
            return ans;
        }
    }

    /**
     * 找到不为 9 的那个数，加 1，后面的全部置 0。
     * @param digits
     * @return
     */
    public int[] plusOneV2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        // digits 元素全为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
