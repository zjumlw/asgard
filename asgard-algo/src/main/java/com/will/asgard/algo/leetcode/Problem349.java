package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Problem349
 * @Description
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther maolingwei
 * @Date 2020-05-14 18:54
 * @Version 1.0
 **/
public class Problem349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        Set<Integer> set = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }

        int k = 0;
        for (int num: nums2) {
            if (set.contains(num)) {
                nums1[k++] = num;
                set.remove(num);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
