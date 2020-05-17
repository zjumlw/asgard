package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @ClassName Problem210
 * @Description
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-05-17 20:42
 * @Version 1.0
 **/
public class Problem210 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }

        // 建立入度表，即学习每门课程对应的先修课门数
        int[] in = new int[numCourses];
        // 每有一组先决条件，则对应要学课程的先修课门数+1
        for (int[] prerequisite : prerequisites) {
            in[prerequisite[0]]++;
        }
        // 将所有入度为0的课程加入队列，即不需要先修课就可以学习的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i : in) {
            if (i == 0) {
                queue.offer(i);
            }
        }
        // 记录可以学完的课程
        int count = 0;
        // 依次存可以学完的课程
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            // 取出队列头的课程，因为没有先决条件，所以可以直接加入可以学习的课程列表
            int curr = queue.poll();
            ans[count++] = curr;

            // 遍历所有先决条件，如果以当前课程为先决条件，则对应的入度-1
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == curr) {
                    in[prerequisite[0]]--;
                    // 将入度变为0的课程加入队列
                    if (in[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }

        return count == numCourses ? ans : new int[0];
    }

    public static int[] findOrderV2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }

        // 建立入度表，即学习每门课程对应的先修课门数
        int[] in = new int[numCourses];
        // 依次存可以学完的课程
        int[] ans = new int[numCourses];
        // 定义 list 数组存储所有作为其他课程先决条件出发的边。
        ArrayList[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList();
        }

        // 每有一组先决条件，则对应要学课程的先修课门数+1
        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            // 将当前先决条件课出发的边加入数组对应的 list 中。
            edges[pre[1]].add(pre[0]);
        }

        // 将所有入度为0的课程加入队列，即不需要先修课就可以学习的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i : in) {
            if (i == 0) {
                queue.offer(i);
            }
        }

        // 记录可以学完的课程
        int count = 0;
        while (!queue.isEmpty()) {
            // 取出队列头的课程，因为没有先决条件，所以可以直接加入可以学习的课程列表
            int curr = queue.poll();
            ans[count++] = curr;
            // 遍历以当前课程出发的边，即以当前课程为先决条件的课入度表对应位置 -1 。
            for (Object terminus : edges[curr]) {
                int t = (int) terminus;
                in[t]--;
                // 将入度变为 0 的课程加入队尾。
                if (in[t] == 0) {
                    queue.offer(t);
                }
            }
        }

        return count == numCourses ? ans : new int[0];
    }

    int count = 0;
    public int[] findOrderV3(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // 建立入度表，即学习每门课程对应的先修课门数
        int[] in = new int[numCourses];
        // 定义数组依次存可以学完的课程。
        int[] ans = new int[numCourses];
        // 定义 list 数组存储所有作为其他课程先决条件出发的边。
        List[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        // 遍历先决条件边缘列表。
        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            // 将当前先决条件课出发的边加入数组对应的 list 中。
            edges[pre[1]].add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                ans[count++] = i;
                in[i] = -1;
                // 递归遍历以当前课为先决条件的课程。
                dfs(edges, edges[i], in, ans);
            }
        }

        return count == numCourses ? ans : new int[0];
    }

    private void dfs(List[] edges, List<Integer> edge, int[] in, int[] ans) {
        // 遍历以当前课程出发的边，即以当前课程为先决条件的课入度表对应位置 -1 。
        for (int terminus : edge) {
            in[terminus]--;
            if (in[terminus] == 0) {
                ans[count++] = terminus;
                in[terminus] = -1;
                dfs(edges, edges[terminus], in, ans);
            }
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{2, 0};
        prerequisites[2] = new int[]{3, 1};
        prerequisites[3] = new int[]{3, 2};

        int[] order = findOrder(4, prerequisites);
        ArrayUtil.printArray(order);

        int[] order2 = findOrderV2(4, prerequisites);
        ArrayUtil.printArray(order2);

        int[] order3 = new Problem210().findOrderV3(4, prerequisites);
        ArrayUtil.printArray(order3);
    }
}
