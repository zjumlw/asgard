package com.will.asgard.loki.model.leetcode;

/**
 * @Description 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] tmp = new int[nums1.length + nums2.length];
		int medianIndex1;
		int medianIndex2;
		if (tmp.length % 2 == 0) {
			medianIndex1 = tmp.length / 2 - 1;
			medianIndex2 = tmp.length / 2;
		} else {
			medianIndex1 = medianIndex2 = (tmp.length - 1) / 2;
		}

		int cursor1 = 0;
		int cursor2 = 0;
		int cursorTmp = 0;
		while (cursorTmp <= medianIndex2) {
			if (cursor1 >= nums1.length) {
				tmp[cursorTmp++] = nums2[cursor2++];
			} else if (cursor2 >= nums2.length) {
				tmp[cursorTmp++] = nums1[cursor1++];
			} else if (nums1[cursor1] <= nums2[cursor2]) {
				tmp[cursorTmp++] = nums1[cursor1++];
			} else {
				tmp[cursorTmp++] = nums2[cursor2++];
			}
		}
		return (tmp[medianIndex1] + tmp[medianIndex2])*1.0 / 2;
	}

	public static void main(String[] args) {
		int[] num1 = new int[]{1, 2};
		int[] num2 = new int[]{3, 4};
		System.out.println(new Problem4().findMedianSortedArrays(num1, num2));
	}
}
