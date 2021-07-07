package com.will.asgard.algo.leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description hard
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式 formula ，返回所有原子的数量。格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1：
 * 输入：formula = "H2O"
 * 输出："H2O"
 * 解释：
 * 原子的数量是 {'H': 2, 'O': 1}。
 *
 * 示例 2：
 * 输入：formula = "Mg(OH)2"
 * 输出："H2MgO2"
 * 解释：
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *
 * 示例 3：
 * 输入：formula = "K4(ON(SO3)2)2"
 * 输出："K4N2O14S4"
 * 解释：
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 * 示例 4：
 * 输入：formula = "Be32"
 * 输出："Be32"
 *
 * 提示：
 * 1 <= formula.length <= 1000
 * formula 由小写英文字母、数字 '(' 和 ')' 组成。
 * formula 是有效的化学式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-07-05 7:27 下午
 * @Version 1.0
 **/
public class Problem726 {

    private int i;
    private int n;
    String formula;

    public String countOfAtoms(String formula) {
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<>());
        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                i++;
                stack.push(new HashMap<>());
            } else if (c == ')') {
                i++;
                int num = parseNum();
                Map<String, Integer> popMap = stack.pop(); // 括号内的原子数量
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> e : popMap.entrySet()) {
                    String atom = e.getKey();
                    int cnt = e.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + cnt * num);
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num);
            }
        }

        Map<String, Integer> tmp = stack.pop();
        TreeMap<String, Integer> map = new TreeMap<>(tmp);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String atom = e.getKey();
            sb.append(atom);
            int count = e.getValue();
            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }

    private String parseAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++));
        }
        return sb.toString();
    }

    private int parseNum() {
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }

        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i++) - '0';
        }
        return num;
    }
}
