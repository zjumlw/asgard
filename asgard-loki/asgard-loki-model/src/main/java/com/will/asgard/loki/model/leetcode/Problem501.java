package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-24 10:45 下午
 * @Version 1.0
 */
public class Problem501 {

    int maxCnt = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCnt) {
                ans.add(entry.getKey());
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        int oldCnt = map.getOrDefault(root.val, 0);
        int newCnt = oldCnt + 1;
        if (newCnt > maxCnt) {
            maxCnt = newCnt;
        }
        map.put(root.val, newCnt);
        helper(root.left, map);
        helper(root.right, map);
    }

    int base;
    int count;
    int maxCount;
    List<Integer> ans = new ArrayList<>();

    public int[] findModeV2(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            // 当前节点没有左子树，处理完自身后遍历右子树
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            // 找到当前节点的前驱节点
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            // 前驱节点为空，说明未处理，将其right指向cur
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
                // 前驱节点不为空，说明已处理，将其right恢复为null
            } else {
                pre.right = null;
                // 处理当前节点值
                update(cur.val);
                cur = cur.right;
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void update(int val) {
        if (val == base) {
            count++;
        } else {
            base = val;
            count = 1;
        }

        if (count == maxCount) {
            ans.add(val);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(val);
        }
    }

    public static void main(String[] args) {
        Problem501 problem501 = new Problem501();
        String data = "1,null,2,2,null,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int[] ans = problem501.findModeV2(root);
        ArrayUtil.printArray(ans);


    }
}
