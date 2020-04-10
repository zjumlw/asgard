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

	public static int nextInt(int bound) {
		return random().nextInt(bound);
	}
}
