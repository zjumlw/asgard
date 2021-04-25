package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-07 5:37 下午
 * @Version 1.0
 */
public class Problem327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        long lbound = Long.MAX_VALUE, rbound = Long.MIN_VALUE;
        for (long x : preSum) {
            lbound = Math.min(Math.min(lbound, x), Math.min(x - lower, x - upper));
            rbound = Math.max(Math.max(rbound, x), Math.max(x - lower, x - upper));
        }

        SegNode root = new SegNode(lbound, rbound);
        int ret = 0;
        for (long x : preSum) {
            ret += count(root, x - upper, x - lower);
            insert(root, x);
        }
        return ret;
    }

    public int count(SegNode root, long left, long right) {
        if (root == null) {
            return 0;
        }
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }

    public void insert(SegNode root, long val) {
        root.add++;
        if (root.lo == root.hi) {
            return;
        }
        long mid = (root.lo + root.hi) >> 1;
        if (val <= mid) {
            if (root.lchild == null) {
                root.lchild = new SegNode(root.lo, mid);
            }
            insert(root.lchild, val);
        } else {
            if (root.rchild == null) {
                root.rchild = new SegNode(mid + 1, root.hi);
            }
            insert(root.rchild, val);
        }
    }

    class SegNode {
        long lo, hi;
        int add;
        SegNode lchild, rchild;

        public SegNode(long left, long right) {
            lo = left;
            hi = right;
            add = 0;
            lchild = null;
            rchild = null;
        }
    }

    public static void main(String[] args) {
        Problem327 problem327 = new Problem327();
        int[] nums = new int[]{-2, 5, 1};
        int lower = -2;
        int upper = 2;
        int ans = problem327.countRangeSum(nums, lower, upper);
        System.out.println(ans);
    }
}
