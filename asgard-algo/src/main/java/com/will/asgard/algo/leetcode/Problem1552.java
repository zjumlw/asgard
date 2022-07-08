package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 1552. 两球之间的磁力 medium
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 *
 * 示例 1：
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 *
 * 示例 2：
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 *
 * 提示：
 *
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magnetic-force-between-two-balls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-07-27 11:57 下午
 * @Version 1.0
 **/
public class Problem1552 {

    /**
     * 数组中任意两个数的绝对值的最小值为 ans = |x - y|
     * 我们要让ans最大
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n - 1] - position[0];
        int ans = -1;
//        System.out.println("left=" + left + ", right=" + right);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(position, m, mid)) {
                ans = mid;
                // 可以放下，加大间距试试
                left = mid + 1;
            } else {
                // 放不下，只能减少间距试试
                right = mid - 1;
            }
        }

        return ans;
    }

    // 查看最小间隔为x时，能否放m个球
    private boolean check(int[] position, int m, int x) {
        int pre = position[0];
        int cnt = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt++;
            }
        }

        return cnt >= m;
    }
}
