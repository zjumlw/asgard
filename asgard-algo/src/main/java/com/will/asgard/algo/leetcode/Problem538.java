package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Auther maolingwei
 * @Date 2020-09-21 10:36
 * @Version 1.0
 **/
public class Problem538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


    public static void main(String[] args) {
        Problem538 problem538 = new Problem538();
        String data = "5,2,null,null,13,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        TreeNode ans = problem538.convertBST(root);
        TreeNodeUtil.printTreeNode(ans);
    }
}
