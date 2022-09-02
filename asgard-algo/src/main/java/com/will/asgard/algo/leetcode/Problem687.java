package com.will.asgard.algo.leetcode;

/**
 * 687. 最长同值路径 medium
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *  
 * 示例 1:
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 *
 * 示例 2:
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 *
 * 提示:
 *
 * 树的节点数的范围是 [0, 10^4] 
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author willmao
 * @date 2022-09-02 20:45
 **/
public class Problem687 {

    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * 以 root 为起点，往下走同值路径所能经过的最大长度（不能同时往左右节点走）。
     *
     * @param root 根节点
     * @return 最大长度
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int cur = 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            ans = l + 1;
            cur += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ans = Math.max(ans, r + 1);
            cur += r + 1;
        }
        max = Math.max(max, cur);
        return ans;
    }
}
