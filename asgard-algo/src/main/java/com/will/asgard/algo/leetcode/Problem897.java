package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description easy
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *  
 *
 * 提示：
 *
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-04-25 上午11:50
 * @Version 1.0
 */
public class Problem897 {

    /**
     * 中序遍历将节点从小到大放到list中，然后遍历list生成答案
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);

        TreeNode dummy = new TreeNode(-1);
        TreeNode current = dummy;
        for (int value : res) {
            current.right = new TreeNode(value);
            current = current.right;
        }
        return dummy.right;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private TreeNode ansNode;

    /**
     * 在中序遍历的过程中，改变节点的指向
     * @param root
     * @return
     */
    public TreeNode increasingBSTV2(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        ansNode = dummy;
        inOrderV2(root);
        return dummy.right;
    }

    private void inOrderV2(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderV2(node.left);

        // 在中序遍历的过程中，修改节点指向
        ansNode.right = node;
        node.left = null;
        ansNode = node;

        inOrderV2(node.right);
    }

    public static void main(String[] args) {
        Problem897 problem897 = new Problem897();
        String data = "5,1,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        TreeNode ans = problem897.increasingBST(root);
        TreeNodeUtil.printTreeNode(ans);

        TreeNode ans2 = problem897.increasingBSTV2(root);
        TreeNodeUtil.printTreeNode(ans2);
    }
}
