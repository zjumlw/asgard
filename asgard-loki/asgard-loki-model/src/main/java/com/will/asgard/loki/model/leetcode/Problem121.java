package com.will.asgard.loki.model.leetcode;

/**
 * @ClassName Problem121
 * @Description
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther maolingwei
 * @Date 2020-06-04 20:11
 * @Version 1.0
 **/
public class Problem121 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int length = prices.length;
        int[] dp = new int[length];
        dp[0] = 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            if (dp[i] >= maxProfit) {
                maxProfit = dp[i];
            }
        }

        ArrayUtil.printArray(dp);

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

        int[] prices2 = new int[]{7, 6, 5, 4, 2, 1};
        int maxProfit2 = maxProfit(prices2);
        System.out.println(maxProfit2);

        int[] prices3 = new int[]{1, 2};
        int maxProfit3 = maxProfit(prices3);
        System.out.println(maxProfit3);
    }
}
