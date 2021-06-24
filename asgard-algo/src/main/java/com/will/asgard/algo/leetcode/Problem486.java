package com.will.asgard.algo.leetcode;

/**
 * @Description medium
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 * 示例 2：
 *
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *  
 *
 * 提示：
 *
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于 10000000 。
 * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-09-01 10:10 下午
 * @Version 1.0
 */
public class Problem486 {

    /**
     * 递归的方法
     * 时间复杂度 O(2^n)
     * 空间复杂度 O(n)
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        /*
         * 对于偶数个数字的数组，玩家1一定获胜。因为如果玩家1选择拿法A，玩家2选择拿法B，
         * 玩家1输了。则玩家1换一种拿法选择拿法B，因为玩家1是先手，所以玩家1一定可以获胜。
         */
        if (nums.length % 2 == 0) {
            return true;
        }

        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @param turn 1代表先手得分，-1代表后手得分
     * @return
     */
    private int total(int[] nums, int left, int right, int turn) {
        // 只有一个数
        if (left == right) {
            return nums[left] * turn;
        }
        int leftScore = nums[left] * turn + total(nums, left + 1, right, -turn);
        int rightScore = nums[right] * turn + total(nums, left, right - 1, -turn);
        if (turn == 1) {
            return Math.max(leftScore, rightScore);
        } else {
            return Math.min(leftScore, rightScore);
        }
    }

    /**
     * 动态规划的方法。
     * dp[i][j]表示当数组剩下的部分为下标i到下标j时，即下标范围[i,j]中，当前玩家与另一个玩家的分数之差的最大值。
     * 当i>j时，dp[i][j]=0。
     * 当i=j时，只有一个数字，当前玩家只能拿这个数字，所以dp[i][i]=nums[i]。
     * 当i<j时，当前玩家可以选择nums[i]或者nums[j]，然后轮到另一个玩家在数组剩下的部分选取数字。而当前玩家会选择最优的方案，
     * 有状态转移方程：dp[i][j]=max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
     *
     * 解释：nums[i]-dp[i+1][j]代表玩家A获取了nums[i]时，另一个玩家B可以和玩家A的分数之差最大值为dp[i+1][j]
     * 则玩家A和玩家B的分数差值之一为 nums[i] - dp[i+1][j]
     * 另一个分数差值为 nums[j] - dp[i][j-1]
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinnerV2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }

    /**
     * 在V2的基础上，可以看到dp[i][j]只和dp[i+1][j]和dp[i][j-1]有关系，所以在计算第i行的时候，只需要使用i行和i+1行的值，
     * 因此可以用一维数组来代替二维数组
     * @param nums
     * @return
     */
    public boolean PredictTheWinnerV3(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }

        return dp[len - 1] >= 0;
    }
}
