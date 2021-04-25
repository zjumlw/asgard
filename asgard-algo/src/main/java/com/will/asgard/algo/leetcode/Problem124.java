package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-25 4:03 下午
 * @Version 1.0
 */
public class Problem124 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftMaxGain = Math.max(maxGain(treeNode.left), 0);
        int rightMaxGain = Math.max(maxGain(treeNode.right), 0);
        int priceNewPath = treeNode.val + leftMaxGain + rightMaxGain;
        maxSum = Math.max(maxSum, priceNewPath);
        return treeNode.val + Math.max(leftMaxGain, rightMaxGain);
    }

    public static void main(String[] args) {
        String str = "1,2,null,null,3,null,null";
        TreeNode root = TreeNodeUtil.deserialize(str);
        int maxPathSum = new Problem124().maxPathSum(root);
        System.out.println(maxPathSum);
    }
}
