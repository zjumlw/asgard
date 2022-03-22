package com.will.asgard.algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description 39. 组合总和 medium
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-09 10:29 下午
 * @Version 1.0
 */
public class Problem39 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 做个排序
        Arrays.sort(candidates);
        // 从第0个元素开始
        dfs(candidates, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, int idx) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int val = target - candidates[i];
            if (val >= 0) {
                tmp.add(candidates[i]);
                System.out.println("递归之前 => " + tmp + ", 剩余 => " + val);
                dfs(candidates, target- candidates[i], i);
                tmp.remove(tmp.size() - 1);
                System.out.println("递归之后 => " + tmp);
            } else {
                System.out.println("剩余小于0，跳过 => " + val);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Problem39 problem39 = new Problem39();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = problem39.combinationSum(candidates, target);
        System.out.println(GsonUtil.toJson(res));
    }

    public List<List<Integer>> combinationSumV1(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs1(candidates, 0, n, target, path, ans);
        return ans;
    }

    private void dfs1(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> ans) {
        // target 为0或者负数时，不再产生新的叶子节点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            dfs1(candidates, i, len, target - candidates[i], path, ans); // 当前元素可以重复使用
            // 状态重置
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(candidates, 0, n, target, path, ans);
        return ans;
    }

    private void dfs2(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 提前剪枝，最小的元素已经大于target了，那么后面的肯定更加不满足，break
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs2(candidates, i, len, target, path, ans);
            path.removeLast();
        }
    }
}
