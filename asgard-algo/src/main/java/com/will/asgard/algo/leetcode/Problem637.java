package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-12 12:55 上午
 * @Version 1.0
 */
public class Problem637 {

    /**
     * 广度优先
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> line = new LinkedList<>();
        line.offer(root);
        while (!line.isEmpty()) {
            int size = line.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = line.poll();
                sum += node.val;
                if (node.left != null) {
                    line.offer(node.left);
                }
                if (node.right != null) {
                    line.offer(node.right);
                }
            }
            Double avg = 1.0 * sum / size;
            ans.add(avg);
        }
        return ans;
    }

    /**
     * 深度优先
     */
    public List<Double> averageOfLevelsV2(TreeNode root) {
        List<Integer> counts = new ArrayList<>();
        List<Long> sums = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        dfs(root, 0, counts, sums);
        for (int i = 0; i < sums.size(); i++) {
            ans.add(i, sums.get(i) * 1.0 / counts.get(i));
        }

        return ans;
    }

    private void dfs(TreeNode root, int level, List<Integer> counts, List<Long> sums) {
        if (root == null) {
            return;
        }
        if (level < counts.size()) {
            counts.set(level, counts.get(level) + 1);
            sums.set(level, sums.get(level) + root.val);
        } else {
            counts.add(1);
            sums.add((long) root.val);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }

    public static void main(String[] args) {
        Problem637 problem637 = new Problem637();
        String data = "3,9,null,null,20,15,null,null,7,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        List<Double> ans = problem637.averageOfLevels(root);
        System.out.println(GsonUtil.toJson(ans));

        List<Double> ans2 = problem637.averageOfLevelsV2(root);
        System.out.println(GsonUtil.toJson(ans2));
    }
}
