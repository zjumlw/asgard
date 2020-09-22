package com.will.asgard.loki.model.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-23 12:27 上午
 * @Version 1.0
 */
public class Problem617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode leftMerge = mergeTrees(t1.left, t2.left);
        TreeNode rightMerge = mergeTrees(t1.right, t2.right);
        TreeNode ans = new TreeNode();
        ans.val = t1.val + t2.val;
        ans.left = leftMerge;
        ans.right = rightMerge;
        return ans;
    }

    public TreeNode mergeTreesV2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merge = new TreeNode();
        merge.val = t1.val + t2.val;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merge);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merge;
    }

    public static void main(String[] args) {
        Problem617 problem617 = new Problem617();
        String data1 = "1,3,5,null,null,null,2,null,null";
        String data2 = "2,1,null,4,null,null,3,null,7,null,null";
        TreeNode t1 = TreeNodeUtil.deserialize(data1);
        TreeNode t2 = TreeNodeUtil.deserialize(data2);

//        TreeNodeUtil.printTreeNode(t1);
//        TreeNodeUtil.printTreeNode(t2);

        TreeNode ans = problem617.mergeTrees(t1, t2);
        TreeNodeUtil.printTreeNode(ans);

        TreeNode ans2 = problem617.mergeTreesV2(t1, t2);
        TreeNodeUtil.printTreeNode(ans2);
    }
}
