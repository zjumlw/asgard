package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description 面试题 17.14. 最小K个数 medium
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-09-04 2:02 下午
 * @Version 1.0
 **/
public class Problem2321 {

    /**
     * 时间复杂度 O(Nlogk)
     * 空间复杂度 O(k)
     */
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    private static final Random random = new Random(System.currentTimeMillis());

    /**
     * 期望时间复杂度 O(n)
     * 期望空间复杂度 O(n)
     */
    public int[] smallestKV2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(arr, left, right);
            if (index == k - 1) {
                break;
            } else if (index < k - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private int partition(int[] arr, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(arr, left, randomIndex);

        int pivot = arr[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                lt++;
                swap(arr, i, lt);
            }
        }
        swap(arr, left, lt);
        return lt;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
