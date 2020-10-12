package com.will.asgard.loki.model.leetcode;

/**
 * @Description
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Auther maolingwei
 * @Date 2020-10-12 11:32
 * @Version 1.0
 **/
public class Problem530 {

    int pre = -1;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        int val = root.val;
        if (pre == -1) {
            pre = val;
        } else {
            if (val - pre < ans) {
                ans = val - pre;
            }
            pre = val;
        }

        dfs(root.right);
    }

    public static void main(String[] args) {
        Problem530 problem530 = new Problem530();
        String data = "1,n,3,2,n,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem530.getMinimumDifference(root);
        System.out.println(ans);
    }
}
