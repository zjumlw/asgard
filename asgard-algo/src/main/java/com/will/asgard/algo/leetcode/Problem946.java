package com.will.asgard.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列 medium
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 提示：
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * pushed 的所有元素 互不相同
 * popped.length == pushed.length
 * popped 是 pushed 的一个排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-stack-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author willmao
 * @date 2022-08-31 22:26
 **/
public class Problem946 {

    /**
     * 每次将 pushed[i] 放入栈中，然后比较当前栈顶元素是否与待弹出的元素相同，如果相同则弹栈并进行 j 自增，
     * 当所有元素处理完成后，栈为空说明栈序列合法。
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequencesV2(int[] pushed, int[] popped) {
        int n = pushed.length;
        // 代指栈顶下标
        int idx = 0;
        for (int i = 0, j = 0; i < n; i++) {
            pushed[idx++] = pushed[i];
            while (idx > 0 && pushed[idx - 1] == popped[j] && ++j >= 0) {
                idx--;
            }
        }
        return idx == 0;
    }
}
