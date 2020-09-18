package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-18 9:17 下午
 * @Version 1.0
 */
public class Problem47 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, used);
        return ans;
    }

    private void dfs(int[] nums, int depth, boolean[] used) {
        int len = nums.length;
        if (depth == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, used);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem47 problem47 = new Problem47();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> ans = problem47.permuteUnique(nums);
        System.out.println(ans);
    }
}
