package com.will.asgard.loki.model.leetcode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @Description
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-07-07 11:19 下午
 * @Version 1.0
 */
public class Problem112 {

    /**
     * 递归
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 广度优先搜索
     */
    public static boolean hasPathSumV2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(temp + now.left.val);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(temp + now.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String data = "5,4,11,null,null,null,8,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        String str = TreeNodeUtil.serialize(root);
        System.out.println(str);

        boolean res1 = hasPathSum(root, 13);
        boolean res2 = hasPathSumV2(root, 13);
        System.out.println(res1);
        System.out.println(res2);
    }
}
