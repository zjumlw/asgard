package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-20 12:20 上午
 * @Version 1.0
 */
public class Problem78 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    /**
     * 回溯算法
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return ans;
        }
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int idx) {
        if (idx == nums.length) {
            // 记录答案
            ans.add(new ArrayList<>(path));
            return;
        }
        // 考虑选择当前位置
        path.add(nums[idx]);
        dfs(nums, idx + 1);
        path.remove(path.size() - 1);
        // 考虑不选择当前位置
        dfs(nums, idx + 1);
    }

    /**
     * 枚举算法
     */
    public List<List<Integer>> subsetsV2(int[] nums) {
        if (nums == null) {
            return ans;
        }
        int len = nums.length;
        for (int mask = 0; mask < (1 << len); mask++) {
            path.clear();
            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    path.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }

    /**
     * 循环枚举
     */
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    /**
     * 递归枚举
     */
    public static void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<Integer>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        recursion(nums, i + 1, res);
    }

    /**
     * DFS，前序遍历
     */
    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<Integer>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，中序遍历
     */
    public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，后序遍历
     */
    public static void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        postOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        postOrder(nums, i + 1, subset, res);
        // 这里
        res.add(subset);
    }

    public static void main(String[] args) {
        Problem78 problem78 = new Problem78();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = problem78.subsetsV2(nums);
        System.out.println(ans);
    }

}
