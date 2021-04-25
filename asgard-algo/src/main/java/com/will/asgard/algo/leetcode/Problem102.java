package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.will.asgard.algo.leetcode.TreeNode;

/**
 * @ClassName Problem102
 * @Description
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-05-13 00:39
 * @Version 1.0
 **/
public class Problem102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> levelVal = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.pollFirst();
                if (treeNode != null) {
                    levelVal.add(treeNode.val);
                    if (treeNode.left != null) {
                        list.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        list.add(treeNode.right);
                    }
                }
            }
            result.add(levelVal);
        }

        return result;
    }
}
