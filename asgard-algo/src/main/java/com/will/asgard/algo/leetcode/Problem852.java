package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 我们把符合下列属性的数组 A 称作山脉：
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *  
 *
 * 示例 1：
 * 输入：[0,1,0]
 * 输出：1
 *
 * 示例 2：
 * 输入：[0,2,1,0]
 * 输出：1
 *
 * 提示：
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-01-08 下午4:19
 * @Version 1.0
 */
public class Problem852 {

    /**
     * 时间 O(n)
     * 空间 O(1)
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }
        int length = arr.length;
        int ans = -1;
        for (int i = 1; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return ans;
    }

    /**
     * 二分
     * 时间  O(nlogn)
     * 空间 O(1)
     */
    public int peakIndexInMountainArrayV2(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] < arr[mi + 1]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Problem852 problem852 = new Problem852();
        int[] arr = new int[]{0, 1, 0};
        int ans = problem852.peakIndexInMountainArray(arr);
        System.out.println(ans);

        int ans2 = problem852.peakIndexInMountainArrayV2(arr);
        System.out.println(ans2);
    }
}
