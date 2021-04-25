package com.will.asgard.algo.common.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.will.asgard.algo.leetcode.ArrayUtil;

/**
 * @ClassName Intersect
 * @Description p350
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @Auther maolingwei
 * @Date 2020-05-14 17:27
 * @Version 1.0
 **/
public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int k = 0;
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt > 0) {
                nums1[k++] = num;
                map.put(num, cnt - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        ArrayUtil.printArray(intersect(nums1, nums2));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        ArrayUtil.printArray(intersect(nums1, nums2));
    }
}
