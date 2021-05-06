package com.will.asgard.algo.leetcode;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description easy
 * 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 *
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *  
 *
 * 提示：
 *
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-05-06 下午1:55
 * @Version 1.0
 */
public class Problem1702 {

    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] ans = new int[length + 1];
        ans[0] = first;
        for (int i = 1; i <= length; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem1702 problem1702 = new Problem1702();
        int[] encoded = new int[]{6, 2, 7, 3};
        int first = 4;
        System.out.println(GsonUtil.toJson(encoded));

        int[] ans = problem1702.decode(encoded, first);
        System.out.println(GsonUtil.toJson(ans));
    }
}
