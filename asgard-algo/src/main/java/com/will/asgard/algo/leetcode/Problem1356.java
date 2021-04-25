package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-06 9:59 上午
 * @Version 1.0
 */
public class Problem1356 {

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int temp = Integer.bitCount(o1) - Integer.bitCount(o2);
                if (temp > 0) {
                    return 1;
                } else if (temp < 0) {
                    return -1;
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int countOfOne(int num) {
        int ret = 0;
        while (num != 0) {
            // 最后一位是1
            if ((num & 1) == 1) {
                ret++;
            }
            // 右移一位
            num = num >> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Problem1356 problem1356 = new Problem1356();
        int[] arr = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] ans = problem1356.sortByBits(arr);
        System.out.println(Arrays.toString(ans));

        System.out.println(Integer.bitCount(5));
    }
}
