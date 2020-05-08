package com.will.asgard.loki.model.leetcode.algs.array;

/**
 * @ClassName RemoveDuplicates
 * @Description p26
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * @Author maolingwei
 * @Date 2020-05-09 00:54
 * @Version 1.0
 **/
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int min = nums[0] - 1;
		int guardIndex = 0;
		int guard = nums[guardIndex];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == guard && i != guardIndex) {
				nums[i] = min;
			} else {
				guardIndex = i;
				guard = nums[guardIndex];
			}
		}

		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > min) {
				nums[cnt++] = nums[i];
			}
		}

		return cnt;
	}

	public static int removeDuplicatesV2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				if (j - i > 0) {
					nums[i] = nums[j];
				}
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3, 3, 4};
		System.out.println(removeDuplicatesV2(nums));
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
