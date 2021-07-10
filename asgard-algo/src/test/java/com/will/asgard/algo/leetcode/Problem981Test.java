package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-10 1:49 下午
 * @Version 1.0
 **/
public class Problem981Test {

    private Problem981 problem981 = new Problem981();

    @Test
    public void test1() {
        int[] nums = new int[]{5, 10, 15, 20, 25, 30};
        int target = 23;
        int ans = find(nums, target);
        System.out.println(ans);
    }

    private int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 肯定不是目标元素，排除，下一个区间[left, mid - 1]
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return nums[left];
    }

    @Test
    public void test2() {
        Problem981.TimeMap timeMap = problem981.new TimeMap();
        timeMap.set("foo", "bar", 1);
        String ans1 = timeMap.get("foo", 1);
        System.out.println(ans1);

        String ans2 = timeMap.get("foo", 3);
        System.out.println(ans2);

        timeMap.set("foo", "bar2", 4);
        String ans3 = timeMap.get("foo", 4);
        System.out.println(ans3);

        String ans4 = timeMap.get("foo", 5);
        System.out.println(ans4);

        String ans5 = timeMap.get("foo", 3);
        System.out.println(ans5);

        // 2
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        String love1 = timeMap.get("love", 5);
        String love2 = timeMap.get("love", 10);
        String love3 = timeMap.get("love", 15);
        String love4 = timeMap.get("love", 20);
        String love5 = timeMap.get("love", 25);
        System.out.println("====love====");
        System.out.println(love1);
        System.out.println(love2);
        System.out.println(love3);
        System.out.println(love4);
        System.out.println(love5);
    }
}