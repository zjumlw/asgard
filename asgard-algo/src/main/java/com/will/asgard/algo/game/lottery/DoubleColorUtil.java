package com.will.asgard.algo.game.lottery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-24 9:50 下午
 * @Version 1.0
 **/
public class DoubleColorUtil {

    private static Set<Integer> redTargets = new HashSet<>();
    private static int blueTarget = -1;
    private static Map<Integer, BonusLevel> map = new HashMap<>();
    static {
        for (BonusLevel bonusLevel : BonusLevel.values()) {
            map.put(bonusLevel.getLevel(), bonusLevel);
        }
    }

    // 输入程序
    public static void run(int[][] myNums, int[] t) {
        init(t);
        for (int[] nums : myNums) {
            calculateBonus(nums);
        }
    }

    private static void init(int[] t) {
        System.out.println("开奖号码是 " + Arrays.toString(t));

        redTargets.clear();
        for (int i = 0; i < 6; i++) {
            redTargets.add(t[i]);
        }

        blueTarget = t[6];
    }

    private static void calculateBonus(int[] src) {
        if (blueTarget < 0) {
            throw new IllegalStateException("未初始化完成");
        }

        int red = 0;
        for (int i = 0; i < 6; i++) {
            if (redTargets.contains(src[i])) {
                red++;
            }
        }

        int blue = 0;
        if (src[6] == blueTarget) {
            blue = 1;
        }

        int level = levelMatch(red, blue);
        if (level > 0) {
            BonusLevel bonusLevel = map.get(level);
            System.out.println("恭喜您！！您的彩票 " + Arrays.toString(src) + " 中了" + bonusLevel.getName() + "，获得奖金" + bonusLevel.getBonus());
        } else {
            System.out.println("不好意思，您的彩票 " + Arrays.toString(src) + " 未中奖");
        }
    }

    private static int levelMatch(int red, int blue) {
        if (red == 6 && blue == 1) {
            return 1;
        }
        if (red == 6) {
            return 2;
        }
        if (red == 5 && blue == 1) {
            return 3;
        }
        if (red == 5 || (red == 4 && blue == 1)) {
            return 4;
        }
        if (red == 4 || (red == 3 && blue == 1)) {
            return 5;
        }
        if (blue == 1) {
            return 6;
        }
        return -1;
    }
}
