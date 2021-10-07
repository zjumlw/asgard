package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description 414. 第三大的数 easy
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 *
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-10-07 3:09 下午
 * @Version 1.0
 **/
public class Problem414 {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 >= 0 && o2 < 0) {
                    return 1;
                } else if (o1 < 0 && o2 >= 0) {
                    return -1;
                }

                return o1 - o2;
            }
        });

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (pq.size() < 3) {
                if (!set.contains(num)) {
                    pq.offer(num);
                    set.add(num);
                }
            } else {
                if (num > pq.peek() && !set.contains(num)) {
                    set.remove(pq.poll());
                    pq.offer(num);
                    set.add(num);
                }
            }
        }

//        System.out.println("size=" + pq.size());
        if (pq.size() == 3) {
            return pq.poll();
        } else {
            int ans = 0;
            while (!pq.isEmpty()) {
                System.out.println(pq.peek());
                ans = pq.poll();
            }
            return ans;
        }
    }

    /*
     排序
     */
    public int thirdMaxV2(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 1, diff = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && ++diff == 3) {
                return nums[i];
            }
        }
        return nums[0];
    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public int thirdMaxV3(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }

    /*
     一次遍历
     */
    public int thirdMaxV4(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}
