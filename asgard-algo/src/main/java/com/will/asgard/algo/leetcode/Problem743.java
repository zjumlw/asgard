package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 743. 网络延迟时间 medium
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 
 * times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 * 示例 1：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 *
 * 示例 3：
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 * 提示：
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-08-08 3:42 下午
 * @Version 1.0
 **/
public class Problem743 {

    private int N = 110;
    private int M = 6010;
    private int INF = Integer.MAX_VALUE / 2;

    /**
     * 邻接矩阵的方法
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(n^3)
     */
    public int networkDelayTime(int[][] ts, int n, int k) {
        int[][] w = new int[N][N];
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 存图
        for (int[] t : ts) {
            int u = t[0];
            int v = t[1];
            int c = t[2];
            w[u][v] = c;
        }
        // 最短路
        floyd(n, w);
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, w[k][i]);
        }

        return ans >= INF / 2 ? -1 : ans;
    }

    private void floyd(int n, int[][] w) {
        // 枚举中转点 -- 枚举起点 -- 枚举终点 -- 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }

    /**
     * 朴素Dijkstra（邻接矩阵）
     * todo
     */
    public int networkDelayTimeV2(int[][] ts, int n, int k) {
        // 邻接矩阵 w[a][b] = c 代表从a到b有权重为c的边
        int[][] w = new int[N][N];
        // dist[x] = y 代表从源点到x的最短距离为y
        int[] dist = new int[N];
        // 记录哪些点已经被更新过
        boolean[] vis = new boolean[N];
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 存图
        for (int[] t : ts) {
            int u = t[0];
            int v = t[1];
            int c = t[2];
            w[u][v] = c;
        }
        // 最短路
        dijkstra(vis, dist, k, n, w);
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }

    private void dijkstra(boolean[] vis, int[] dist, int k, int n, int[][] w) {
        // 先将所有的点标记为未更新和距离为正无穷
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点的最短距离为 0
        dist[k] = 0;
        // 迭代n次
        for (int p = 1; p <= n; p++) {
            int t = -1;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) {
                    t = i;
                }
            }
            vis[t] = true;
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] * w[t][i]);
            }
        }
    }
}
