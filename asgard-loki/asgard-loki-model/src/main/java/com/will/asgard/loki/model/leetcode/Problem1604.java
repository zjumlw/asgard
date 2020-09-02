package com.will.asgard.loki.model.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Problem1604
 * @Description
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Auther maolingwei
 * @Date 2020-09-02 19:25
 * @Version 1.0
 **/
public class Problem1604 {

    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        Map<CharType, State> initialMap = new HashMap<>();
        initialMap.put(CharType.CHAR_SPACE, State.STATE_INITIAL);
        initialMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        initialMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        initialMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        transfer.put(State.STATE_INITIAL, initialMap);

        Map<CharType, State> intSignMap = new HashMap<>();
        intSignMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intSignMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        Map<CharType, State> integerMap = new HashMap<>();
        integerMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        integerMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        integerMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        integerMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_INTEGER, integerMap);

        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        pointMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_POINT, pointMap);

        Map<CharType, State> pointWithoutIntMap = new HashMap<>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        fractionMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_FRACTION, fractionMap);

        Map<CharType, State> expMap = new HashMap<>();
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        transfer.put(State.STATE_EXP, expMap);

        Map<CharType, State> expSignMap = new HashMap<>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        Map<CharType, State> expNumberMap = new HashMap<>();
        expNumberMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expNumberMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        Map<CharType, State> endMap = new HashMap<>();
        endMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType charType = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(charType)) {
                return false;
            } else {
                state = transfer.get(state).get(charType);
            }
        }

        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    private CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }

    public static void main(String[] args) {
        String s = " ";
        boolean b = new Problem1604().isNumber(s);
        System.out.println(b);
    }
}
