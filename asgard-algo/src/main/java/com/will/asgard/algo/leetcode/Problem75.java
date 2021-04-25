package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-09 9:19 下午
 * @Version 1.0
 */
public class Problem75 {

    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }

        int redCnt = 0;
        int whiteCnt = 0;
        int blueCnt = 0;

        for (int num : nums) {
            if (num == 0) {
                redCnt++;
            }
            if (num == 1) {
                whiteCnt++;
            }
            if (num == 2) {
                blueCnt++;
            }
        }
        int idx = 0;
        while (redCnt > 0 || whiteCnt > 0 || blueCnt > 0) {
            if (redCnt-- > 0) {
                nums[idx++] = 0;
                continue;
            }
            if (whiteCnt-- > 0) {
                nums[idx++] = 1;
                continue;
            }
            if (blueCnt-- > 0) {
                nums[idx++] = 2;
                continue;
            }
        }
    }

    public void sortColorsV2(int[] nums) {
        int len = nums.length;
        int ptr = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[ptr];
                nums[ptr++] = 0;
            }
        }
        for (int i = ptr; i < len; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[ptr];
                nums[ptr++] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Problem75 problem75 = new Problem75();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        problem75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
