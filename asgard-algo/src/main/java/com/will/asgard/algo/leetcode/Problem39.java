package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description
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
}
