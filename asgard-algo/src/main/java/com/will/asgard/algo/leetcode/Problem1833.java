package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description medium
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
 * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 * 示例 1：
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * 示例 2：
 *
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * 示例 3：
 *
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 *  
 *
 * 提示：
 *
 * costs.length == n
 * 1 <= n <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= coins <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-07-02 10:32 上午
 * @Version 1.0
 **/
public class Problem1833 {

    /**
     * 时间复杂度 O(nlogn) 数组排序是O(nlogn) 遍历数组是O(n)，所以总的是O(nlogn)
     * 空间复杂度 O(logn) 排序使用的额外空间
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int ans = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                ans++;
                coins -= cost;
            } else {
                break;
            }
        }
        return ans;
    }

    public int maxIceCreamV2(int[] costs, int coins) {
        // 计数排序
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }

        int ans = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                // 可以购买的数量
                int curCount = Math.min(freq[i], coins / i);
                ans += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }

        return ans;
    }
}
