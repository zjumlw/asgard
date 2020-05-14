package com.will.asgard.loki.model.leetcode.algs.array;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @ClassName MoveZeroes
 * @Description p283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @Auther maolingwei
 * @Date 2020-05-14 19:40
 * @Version 1.0
 **/
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[a];
                nums[a++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        ArrayUtil.printArray(nums);
    }

}
