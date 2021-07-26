package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 1893. 检查是否区域内所有整数都被覆盖 easy
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 * 示例 1：
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 *
 * 示例 2：
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *
 * 提示：
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-07-23 11:03 下午
 * @Version 1.0
 **/
public class Problem1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                flag[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        return true;
    }

    // 方法1的优化
    public boolean isCoveredV2(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] range : ranges) {
            int L = Math.max(range[0], left);
            int R = Math.min(range[1], right);
            for (int i = L; i <= R; i++) {
                flag[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isCoveredV3(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a1, a2) -> a1[0] - a2[0]);
        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (l <= left && left <= r) {
                left = r + 1;
            }
        }

        return left > right;
    }

    // 差分数组
    public boolean isCoveredV4(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int i = 0; i < ranges.length; i++) {
            diff[ranges[i][0]]++;
            diff[ranges[i][1] + 1]--;
        }
        int[] sum = new int[52];
        for (int i = 1; i <= 51; i++) {
            sum[i] = sum[i - 1] + diff[i];
        }
        for (int i = left; i <= right; i++) {
            if (sum[i] <= 0) {
                return false;
            }
        }
        return true;
    }
}
