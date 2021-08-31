package com.will.asgard.algo.leetcode;

/**
 * @Description 443. 压缩字符串 medium
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 * 示例 1：
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 *
 * 示例 2：
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 *
 * 示例 3：
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 *
 * 提示：
 *
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-08-21 2:17 下午
 * @Version 1.0
 **/
public class Problem443 {

    public int compress(char[] chars) {
        char prev = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == prev) {
                count++;
            } else {
                sb.append(prev);
                if (count > 1) {
                    sb.append(count);
                }
                prev = c;
                count = 1;
            }
        }
        sb.append(prev);
        if (count > 1) {
            sb.append(count);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }

    public int compressV2(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            int idx = i;
            while (idx < n && chars[idx] == chars[i]) {
                idx++;
            }
            int count = idx - i;
            chars[j++] = chars[i]; // 填字符
            j = helper(chars, j, count); // 填数字
            i = idx;
        }

        print(chars, j);

        return j;
    }

    private int helper(char[] chars, int index, int num) {
        if (num >= 10) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                chars[index++] = s.charAt(i);
            }
        } else if (num > 1) {
            chars[index++] = (char) (num + '0');
        }
        return index;
    }

    private void print(char[] chars, int size) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(chars[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
