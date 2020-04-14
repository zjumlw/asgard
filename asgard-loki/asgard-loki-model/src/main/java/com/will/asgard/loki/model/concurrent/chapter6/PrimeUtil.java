package com.will.asgard.loki.model.concurrent.chapter6;

/**
 * @ClassName PrimeUtil
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-14 00:38
 * @Version 1.0
 **/
public class PrimeUtil {
	private PrimeUtil() {
	}

	public static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
