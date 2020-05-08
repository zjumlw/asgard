package com.will.asgard.loki.model.leetcode.algs.array;

/**
 * @ClassName RemoveDuplicates
 * @Description p26
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
