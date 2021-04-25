package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description easy
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *  
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-01-05 下午10:05
 * @Version 1.0
 */
public class Problem830 {

    /**
     * 双指针法
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int p1 = 0;
        int p2 = 1;
        while (p1 < length && p2 < length) {
            char c1 = chars[p1];
            while (p2 < length && chars[p2] == c1) {
                p2++;
            }
            if (p2 - p1 >= 3) {
                List<Integer> path = new ArrayList<>();
                path.add(p1);
                path.add(p2 - 1);
                ans.add(path);
            }
            p1 = p2;
            p2 = p2 + 1;
        }
        return ans;
    }

    public List<List<Integer>> largeGroupPositionsV2(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = s.length();
        char[] chars = s.toCharArray();
        int num = 1;
        for (int i = 0; i < length; i++) {
            if (i == length - 1 || chars[i] != chars[i + 1]) {
                if (num >= 3) {
                    ans.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem830 problem830 = new Problem830();
        String s = "abbxxxxzzy";
        List<List<Integer>> ans = problem830.largeGroupPositions(s);
        System.out.println(ans);

        List<List<Integer>> ans2 = problem830.largeGroupPositionsV2(s);
        System.out.println(ans2);
    }
}
