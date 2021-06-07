package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-06-01 下午5:04
 * @Version 1.0
 */
public class Problem461 {

    public int hammingDistance(int x, int y) {
        // 内置方法
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistanceV2(int x, int y) {
        int s = x ^ y;
        int ans = 0;
        // 不断右移
        while (s != 0) {
            ans += s & 1;
            s >>= 1;
        }
        return ans;
    }

    public int hammingDistanceV3(int x, int y) {
        int s = x ^ y;
        int ans = 0;
        while (s != 0) {
            s &= s - 1;
            ans++;
        }
        return ans;
    }
}

