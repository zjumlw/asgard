package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-27 12:09 上午
 * @Version 1.0
 */
public class Problem235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);
        printList(path1);
        printList(path2);

        TreeNode ans = root;
        Iterator<TreeNode> it1 = path1.iterator();
        Iterator<TreeNode> it2 = path2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            TreeNode next1 = it1.next();
            TreeNode next2 = it2.next();
            if (next1.val == next2.val) {
                ans = next1;
            } else {
                break;
            }
        }

        return ans;
    }

    private List<TreeNode> findPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        if (root == null || node == null) {
            return path;
        }
        TreeNode cur = root;
        path.add(cur);
        while (cur.val != node.val) {
            if (cur.val < node.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
            path.add(cur);
        }
        return path;
    }

    private void printList(List<TreeNode> path) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : path) {
            if (sb.length() != 0) {
                sb.append("->");
            }
            sb.append(node.val);
        }
        System.out.println(sb.toString());
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            if (p.val < ans.val && q.val < ans.val) {
                ans = ans.left;
            } else if (p.val > ans.val && q.val > ans.val) {
                ans = ans.right;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem235 problem235 = new Problem235();
        String data = "6,2,0,n,n,4,3,n,n,5,n,n,8,7,n,n,9,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        TreeNode ans = problem235.lowestCommonAncestor(root, p, q);
        System.out.println(ans.val);

        TreeNode ans2 = problem235.lowestCommonAncestorV2(root, p, q);
        System.out.println(ans2.val);
    }
}
