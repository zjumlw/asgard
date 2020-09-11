package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-10 9:54 下午
 * @Version 1.0
 */
public class Problem40 {

    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                freq.get(size - 1)[1]++;
            }
        }
        dfs(target, 0);
        return ans;
    }

    private void dfs(int target, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (idx == freq.size() || target < freq.get(idx)[0]) {
            return;
        }
        dfs(target, idx + 1);
        // 当前数字最多可以使用几次
        int most = Math.min(freq.get(idx)[1], target / freq.get(idx)[0]);
        for (int i = 1; i <= most; i++) {
            tmp.add(freq.get(idx)[0]);
            dfs(target - i * freq.get(idx)[0], idx + 1);
        }
        for (int i = 1; i <= most; i++) {
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2V2(int[] candidates, int target) {
        if (target == 0) {
            return ans;
        }
        // 先排序
        Arrays.sort(candidates);
        dfsV2(candidates, target, 0);
        return ans;
    }

    private void dfsV2(int[] candidates, int target, int idx) {
        // 找到目标集合
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 从idx开始遍历candidates
        for (int i = idx; i < candidates.length; i++) {
            // 大剪枝，减去当前最小的都小于0了，更不论后面的数更大
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝，重复的数字，跳过，因为每个数字只能用一次
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp.add(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfsV2(candidates, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Problem40 problem40 = new Problem40();
        List<List<Integer>> ans = problem40.combinationSum2(nums, target);
        System.out.println(GsonUtil.toJson(ans));

        Problem40 problem40V2 = new Problem40();
        List<List<Integer>> ans2 = problem40V2.combinationSum2V2(nums, target);
        System.out.println(GsonUtil.toJson(ans2));
    }

}
