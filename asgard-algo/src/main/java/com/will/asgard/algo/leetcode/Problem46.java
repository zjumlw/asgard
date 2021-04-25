package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Auther maolingwei
 * @Date 2020-09-18 11:32
 * @Version 1.0
 **/
public class Problem46 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
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
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                System.out.println("递归之前 ==> " + path);
                dfs(nums, depth + 1, used);

                used[i] = false;
                path.remove(path.size() - 1);
                System.out.println("递归之后 ==> " +path);
            }
        }
    }

    public static void main(String[] args) {
        Problem46 problem46 = new Problem46();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = problem46.permute(nums);
        System.out.println(GsonUtil.toJson(ans));
    }
}
