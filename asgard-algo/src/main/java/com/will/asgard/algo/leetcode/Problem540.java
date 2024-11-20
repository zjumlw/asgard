package com.will.asgard.algo.leetcode;

/**
 * @Description 540. 有序数组中的单一元素 medium
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 提示:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2022-02-14 9:33 PM
 * @Version 1.0
 **/
public class Problem540 {

    /**
     * 利用异或的原理
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    /**
     * 二分法
     * 如果没有单元素，那么成对元素中的第一个元素对应的下标是偶数，成对元素中的第二个元素对应的下表是奇数。
     * 因为有单元素了，那么单元素左边的元素依然满足上述结论，单元素右边的元素刚好结论相反。
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicateV2(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            // 偶数
            if (mid % 2 == 0) {
                // 单元素在下标 mid 右边
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[l];
    }

    /**
     * 二分+异或
     * @param nums
     * @return
     */
    public int singleNonDuplicateV3(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
