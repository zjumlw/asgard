package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 611. 有效三角形的个数 medium
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-08-13 11:35 下午
 * @Version 1.0
 **/
public class Problem611 {

    /**
     * 排序 + 二分
     * 时间复杂度 O(n^2 * logn)
     * 空间复杂度 O(logn)
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int l = 0;
                int r = j - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (nums[mid] + nums[j] > nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                if (l == r && nums[r] + nums[j] > nums[i]) {
                    ans += j - r;
                }
            }
        }
        return ans;
    }

    /**
     * 排序 + 双指针
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(logn)
     */
    public int triangleNumberV2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1, k = 0; k < j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) {
                    k++;
                }
                ans += j - k;
            }
        }

        return ans;
    }
}
