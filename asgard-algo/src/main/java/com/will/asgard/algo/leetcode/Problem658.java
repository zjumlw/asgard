package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 658. 找到 K 个最接近的元素 medium
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 示例 1：
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 * 提示：
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10^4
 * 数组里的每个元素与 x 的绝对值不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-07-18 7:15 下午
 * @Version 1.0
 **/
public class Problem658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();

        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left > 0 && Math.abs(arr[left - 1] - x) <= Math.abs(arr[left] - x)) {
            left--;
        }
        System.out.println("left=" + left + ", num=" + arr[left]);
        int l = left;
        int r = left;
        while (r - l + 1 < k) {
            if (l == 0) {
                r = k - 1;
                break;
            } else if (r == n - 1) {
                l = n - k;
                break;
            }

            if (Math.abs(arr[l - 1] - x) <= Math.abs(arr[r + 1] - x)) {
                l--;
            } else {
                r++;
            }
        }

        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println("left=" + left + ", right=" + right);

        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
