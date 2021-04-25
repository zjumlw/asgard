package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description medium
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-12-31 上午10:51
 * @Version 1.0
 */
public class Problem435 {

    /**
     * 动态规划的方法
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        return n - Arrays.stream(f).max().getAsInt();
    }

    /**
     * 贪心算法
     * 1. 从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
     * 2. 把所有与 x 区间相交的区间从区间集合 intvs 中删除。
     * 3. 重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
     */
    public int eraseOverlapIntervalsV2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 对数组按照end从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        Problem435 problem435 = new Problem435();
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int ans = problem435.eraseOverlapIntervalsV2(intervals);
        System.out.println(ans);
    }
}
