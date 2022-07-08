package com.will.asgard.algo.game.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.will.asgard.algo.game.lottery.api.cwl.Prizegrade;
import com.will.asgard.algo.game.lottery.api.cwl.SsqResult;
import com.will.asgard.common.util.GsonUtil;

/**
 * @Description TODO
 * @Author zjumlw
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

        List<Integer> redBolls = new ArrayList<>();
        int red = 0;
        for (int i = 0; i < 6; i++) {
            if (redTargets.contains(src[i])) {
                redBolls.add(src[i]);
                red++;
            }
        }

        int blue = 0;
        if (src[6] == blueTarget) {
            blue = 1;
        }

        int level = levelMatch(red, blue);
        StringBuilder msg = new StringBuilder();
        if (level > 0) {
            BonusLevel bonusLevel = map.get(level);
            msg.append("恭喜您！！您的彩票 ")
                    .append(Arrays.toString(src))
                    .append(" 中了")
                    .append(bonusLevel.getName())
                    .append("，获得奖金")
                    .append(bonusLevel.getBonus());
            if (redBolls.size() > 0) {
                msg.append(" ==> 红球的相同号码是：").append(GsonUtil.toJson(redBolls));
            }
            // 蓝球相同
            if (blue == 1) {
                msg.append("，蓝球号码是：").append(blueTarget);
            }
        } else {
            msg.append("不好意思，您的彩票 ")
                    .append(Arrays.toString(src))
                    .append(" 未中奖");
            if (redBolls.size() > 0) {
                msg.append(" ==> 红球的相同号码是：").append(GsonUtil.toJson(redBolls));
            }
        }
        System.out.println(msg);
    }

    public static int levelMatch(int red, int blue) {
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

    public static void matchHistory(int[] myBalls, List<SsqResult> historyResult) {
        for (SsqResult r : historyResult) {
            int redMatch = 0;
            int blueMatch = 0;

            Set<Integer> redSets = new HashSet<>();
            int[] red = r.getRed();
            for (int e : red) {
                redSets.add(e);
            }
            for (int i = 0; i <= 5; i++) {
                if (redSets.contains(myBalls[i])) {
                    redMatch++;
                }
            }

            int blue = r.getBlue();
            if (myBalls[6] == blue) {
                blueMatch = 1;
            }

            int level = levelMatch(redMatch, blueMatch);
            if (level > 0) {
                List<Prizegrade> prizeGrades = r.getPrizeGrades();
                for (Prizegrade prizeGrade : prizeGrades) {
                    if (Integer.parseInt(prizeGrade.getType()) == level) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("恭喜您于 ")
                                .append(r.getDate())
                                .append(" 中 ")
                                .append(level)
                                .append(" 等奖，奖金 ")
                                .append(prizeGrade.getTypemoney())
                                .append(" 元，和你一起中奖的有 ")
                                .append(prizeGrade.getTypenum())
                                .append(" 人");
                        if (level == 1) {
                            sb.append("，他们来自")
                                    .append(r.getContent());
                        }
                        System.out.println(sb);
                        break;
                    }
                }
            }
        }
    }
}
