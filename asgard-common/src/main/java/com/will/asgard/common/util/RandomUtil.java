package com.will.asgard.common.util;

import java.util.Random;

/**
 * @ClassName RandomUtil
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 16:13
 * @Version 1.0
 **/
public class RandomUtil {

    private static final ThreadLocal<Random> trnd = ThreadLocal.withInitial(Random::new);

    private static Random random() {
        return trnd.get();
    }

    public static int nextInt() {
        return random().nextInt();
    }

    /**
     * 随机获取整型，最大值小于bound，取不到bound，取值范围 [0, bound)
     * @param bound 边界，取不到
     * @return 随机整型
     */
    public static int nextInt(int bound) {
        return random().nextInt(bound);
    }

    /**
     * 随机获取最小值和最大值之间的整型，取值范围 [min, max]
     * @param min 最小值
     * @param max 最大值
     * @return 最小值和最大值之间的整型
     */
    public static int betweenInt(int min, int max) {
        return min + random().nextInt(max - min + 1);
    }
}
