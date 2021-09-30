package com.will.asgard.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 447. 回旋镖的数量 medium
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 *
 *  
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 *
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-09-13 9:29 上午
 * @Version 1.0
 **/
public class Problem447 {

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        // 回旋镖至少要3个点
        if (n <= 2) {
            return 0;
        }

        int ans = 0;
        for (int[] point : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] p : points) {
                int dis = (point[0] - p[0]) * (point[0] - p[0]) + (point[1] - p[1]) * (point[1] - p[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                int m = e.getValue();
                ans += m * (m - 1);
            }
        }

        return ans;
    }
}
