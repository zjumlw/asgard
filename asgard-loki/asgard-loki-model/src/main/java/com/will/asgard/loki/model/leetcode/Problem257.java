package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-09-04 10:00 下午
 * @Version 1.0
 */
public class Problem257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(node.val);
            if (node.left == null && node.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                constructPaths(node.left, sb.toString(), paths);
                constructPaths(node.right, sb.toString(), paths);
            }
        }
    }

    public List<String> binaryTreePathsV2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        String data = "2,1,null,5,null,null,2,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        Problem257 problem = new Problem257();

        List<String> paths = problem.binaryTreePaths(root);
        System.out.println(paths);

        List<String> paths2 = problem.binaryTreePathsV2(root);
        System.out.println(paths2);

        TreeNodeUtil.printTreeNode(root);
    }
}
