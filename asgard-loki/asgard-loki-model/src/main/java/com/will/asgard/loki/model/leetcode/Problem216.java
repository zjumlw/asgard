package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-09-11 9:32 下午
 * @Version 1.0
 */
public class Problem216 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n < 1 || n > 45) {
            return ans;
        }
        dfs(k, n, 1);
        return ans;
    }

    private void dfs(int left, int target, int start) {
        if (left == 0 && target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (left < 0 || target < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(left - 1, target - i, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        Problem216 problem216 = new Problem216();
        List<List<Integer>> ans = problem216.combinationSum3(k, n);
        System.out.println(GsonUtil.toJson(ans));
    }
}
