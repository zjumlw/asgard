package com.will.asgard.algo.common.search;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-15 1:52 上午
 * @Version 1.0
 */
public class BinarySearch {

    public int findTarget(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target) {
        // 在[left,right]中寻找target
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 6;
        int idx = binarySearch.findTarget(nums, target);
        System.out.println(idx);
    }
}
