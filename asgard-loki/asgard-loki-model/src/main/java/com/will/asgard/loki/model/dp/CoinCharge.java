package com.will.asgard.loki.model.dp;

/**
 * @ClassName CoinCharge
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-09 00:34
 * @Version 1.0
 **/
public class CoinCharge {

	public static int solution(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = dp[i - coin] + 1;
				}
			}
		}
		return dp[amount] == 0 ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(solution(coins, amount));
	}
}
