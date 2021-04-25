package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Description
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-26 9:10 下午
 * @Version 1.0
 */
public class Problem113 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);
    }

    private List<List<Integer>> ret = new ArrayList<>();
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return ret;
    }

    private void getPath(TreeNode node) {
        List<Integer> tmp = new ArrayList<>();
        while (node != null) {
            tmp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(tmp);
        ret.add(new ArrayList<>(tmp));
    }

    public static void main(String[] args) {
        Problem113 problem113 = new Problem113();
        String data = "5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,5,null,null,1,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int sum = 22;
        List<List<Integer>> ans = problem113.pathSum(root, sum);
        System.out.println(ans);

        List<List<Integer>> ans2 = problem113.pathSum2(root, sum);
        System.out.println(ans2);
    }
}
