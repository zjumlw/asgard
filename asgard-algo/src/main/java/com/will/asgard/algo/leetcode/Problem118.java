package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description easy
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-12-06 下午10:18
 * @Version 1.0
 */
public class Problem118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> first = new ArrayList<>();
                first.add(1);
                ans.add(first);
            } else {
                List<Integer> prev = ans.get(i - 1);
                List<Integer> cur = helper(prev);
                ans.add(cur);
            }
        }
        return ans;
    }

    private List<Integer> helper(List<Integer> prev) {
        int prevSize = prev.size();
        int curSize = prevSize + 1;
        Integer[] temp = new Integer[curSize];

        for (int i = 0; i <= curSize / 2; i++) {
            int added = 1;
            if (i != 0) {
                added = prev.get(i - 1);
                if (prevSize > 1) {
                    added += prev.get(i);
                }
            }
            temp[i] = added;
            temp[curSize - 1 - i] = added;
        }
        return Arrays.asList(temp);
    }

    public static void main(String[] args) {
        Problem118 problem118 = new Problem118();
        int numRows = 5;
        List<List<Integer>> ans = problem118.generate(numRows);
        System.out.println(GsonUtil.toJson(ans));
    }
}
