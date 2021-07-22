package com.will.asgard.algo.leetcode;

import com.will.asgard.common.util.CommonUtil;

/**
 * @Description 875. 爱吃香蕉的珂珂 medium
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *  
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-07-20 10:12 下午
 * @Version 1.0
 **/
public class Problem875 {

    /**
     * 时间复杂度 O(Nlogmax(piles))
     * 空间复杂度 O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = 0;
        long sum = 0;
        long t1 = CommonUtil.getCurrentTimestamp();
        for (int pile : piles) {
            sum += pile;
            maxPile = Math.max(maxPile, pile);
        }

        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println("part1=" + (t2 - t1) + " ms");
        System.out.println("sum=" + sum);
        // 如果left从1开始，时间复杂度没有明显区别
        int left = (int) ((sum + h - 1) / h);
        int right = maxPile;
        System.out.println("left=" + left + ", right=" + right);

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果超时，下一个区间 [mid + 1, right]
            if (overtime(piles, h, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        long t3 = CommonUtil.getCurrentTimestamp();
        System.out.println("part3=" + (t3 - t2) + " ms");
        return left;
    }

    private boolean overtime(int[] piles, int h, int speed) {
        int total = 0;
        for (int pile : piles) {
            total += (pile + speed - 1) / speed;
            if (total > h) {
                return true;
            }
        }

        return false;
    }

}
