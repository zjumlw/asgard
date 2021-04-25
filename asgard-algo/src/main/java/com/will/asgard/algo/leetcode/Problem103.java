package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description medium
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-12-24 上午11:00
 * @Version 1.0
 */
public class Problem103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    deque.offer(node.val);
                } else {
                    deque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(new ArrayList<>(deque));

            // 切换
            flag = !flag;
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem103 problem103 = new Problem103();
        String data = "3,9,n,n,20,15,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        List<List<Integer>> ans = problem103.zigzagLevelOrder(root);
        System.out.println(GsonUtil.toJson(ans));
    }
}
