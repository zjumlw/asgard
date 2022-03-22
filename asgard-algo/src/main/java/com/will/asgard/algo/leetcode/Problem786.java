package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 786. 第 K 个最小的素数分数 hard
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 *
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *
 *  
 * 示例 1：
 *
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 示例 2：
 *
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 *  
 *
 * 提示：
 *
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-11-29 12:23 下午
 * @Version 1.0
 **/
public class Problem786 {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1] * o2[0] - o1[0] * o2[1], 0);
            }
        });

        int n = arr.length;
        if (n == 2) {
            return new int[]{arr[0], arr[n - 1]};
        }
        System.out.println("n=" + n);
        for (int i = 0; i <= n - 2; i++) {
            int minJ = Math.max(i + 1, n - k);
//            System.out.println("i=" + i + ", minJ=" + minJ);
            for (int j = n - 1; j >= minJ; j--) {
                if (queue.size() < k) {
                    queue.offer(new int[]{arr[i], arr[j]});
                } else {
                    int[] peek = queue.peek();
                    int[] temp = new int[]{arr[i], arr[j]};
                    // temp < peek
                    if (compare0(temp, peek) == 1) {
                        queue.poll();
                        queue.offer(temp);
                    }
                }
            }
        }

//        System.out.println(queue.size());
        return queue.poll();
    }

    /*
      o1 > o2: -1
      o1 < o2: 1
      o1 = o2: 0
     */
    private static int compare0(int[] o1, int[] o2) {
        return Integer.compare(o1[1] * o2[0] - o1[0] * o2[1], 0);
    }

    public int[] kthSmallestPrimeFractionV2(int[] arr, int k) {
        int n = arr.length;
        // 小的在前
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double d1 = arr[o1[0]] * 1.0 / arr[o1[1]];
                double d2 = arr[o2[0]] * 1.0 / arr[o2[1]];
                return Double.compare(d1, d2);
            }
        });
        // 放了 n -1 个
        for (int i = 1; i < n; i++) {
            queue.offer(new int[]{0, i});
        }
        while (k-- > 1) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            if (i + 1 < j) {
                queue.offer(new int[]{i + 1, j});
            }
        }
        int[] poll = queue.poll();
        return new int[]{arr[poll[0]], arr[poll[1]]};
    }

    double eps = 1e-8;
    int a;
    int b;
    public int[] kthSmallestPrimeFractionV3(int[] arr, int k) {
        double l = 0;
        double r = 1;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid, arr) >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return new int[]{a, b};
    }

    // 假设x为分割点，那么小于等于x的值，其左边分数值个数小于k个；大于x的值，其左边分数值个数大于k个
    // 判断x左边的分数值个数
    private int check(double x, int[] arr) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0, j = 1; j < n; j++) {
            while (arr[i + 1] * 1.0 / arr[j] <= x) {
                i++;
            }
            double temp = arr[i] * 1.0 / arr[j];
            if (temp <= x) {
                ans += i + 1;
            }
            if (Math.abs(temp - x) < eps) {
                a = arr[i];
                b = arr[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 7};
        int n = arr.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double d1 = arr[o1[0]] * 1.0 / arr[o1[1]];
                double d2 = arr[o2[0]] * 1.0 / arr[o2[1]];
                return Double.compare(d1, d2);
            }
        });
        for (int i = 1; i < n; i++) {
            queue.offer(new int[]{0, i});
        }

        while (!queue.isEmpty()) {
            System.out.println(Arrays.toString(queue.poll()));
        }
    }
}
