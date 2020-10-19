package com.will.asgard.loki.model.leetcode;

/**
 * @Description
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Auther maolingwei
 * @Date 2020-10-19 14:07
 * @Version 1.0
 **/
public class Problem844 {

    public boolean backspaceCompare(String S, String T) {
        int idx1 = S.length() - 1;
        int idx2 = T.length() - 1;
        int jumpCnt1 = 0;
        int jumpCnt2 = 0;

        while (idx1 >= 0 || idx2 >= 0) {
            while (idx1 >= 0) {
                if ('#' == S.charAt(idx1)) {
                    jumpCnt1++;
                    idx1--;
                } else if (jumpCnt1 > 0) {
                    jumpCnt1--;
                    idx1--;
                } else {
                    break;
                }
            }

            while (idx2 >= 0) {
                if ('#' == T.charAt(idx2)) {
                    idx2--;
                    jumpCnt2++;
                } else if (jumpCnt2 > 0) {
                    jumpCnt2--;
                    idx2--;
                } else {
                    break;
                }
            }

            // 对比有效的char
            if (idx1 >= 0 && idx2 >= 0) {
                if (S.charAt(idx1) != T.charAt(idx2)) {
                    return false;
                }
            } else {
                // 其中一个遍历完，另一个没有
                if (idx1 >= 0 || idx2 >= 0) {
                    return false;
                }
            }
            idx1--;
            idx2--;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem844 problem844 = new Problem844();

        String str1 = "ccab##";
        String str2 = "c";
        boolean b = problem844.backspaceCompare(str1, str2);
        System.out.println(b);
    }
}
