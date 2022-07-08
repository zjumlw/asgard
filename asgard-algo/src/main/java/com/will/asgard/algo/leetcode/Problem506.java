package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description 506. 相对名次 easy
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 *
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 * 提示：
 * n == score.length
 * 1 <= n <= 10^4
 * 0 <= score[i] <= 10^6
 * score 中的所有值 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author zjumlw
 * @Date 2021-12-02 10:49 下午
 * @Version 1.0
 **/
public class Problem506 {

    private static String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        Map<Integer,Integer> map = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        int rank = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans[e.getValue()] = rank < 3 ? desc[rank] : String.valueOf(rank + 1);
            rank++;
        }

        return ans;
    }

    public String[] findRelativeRanksV2(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < score.length; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        int rank = 0;
        for (int[] array : arr) {
            ans[array[1]] = rank < 3 ? desc[rank] : String.valueOf(rank + 1);
            rank++;
        }
        return ans;
    }
}
