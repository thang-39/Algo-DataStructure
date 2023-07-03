package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {

        System.out.println(coinChangeRecurrence(new int[] {1,3,4,5},7));
        System.out.println(coinChangeRecurrence(new int[]{2},3));
        System.out.println(coinChangeRecurrence(new int[]{1,2,5},100));

    }

    // top down - Memorization
    public static int coinChangeRecurrence(int[] coins, int amount) {

        Map<Integer,Integer> cache = new HashMap<>();

        int min_coins = recurrence(coins, amount, cache);
        if (min_coins >= (int) Math.pow(10,9)) return -1;
        else return min_coins;
    }
    private static int recurrence(int[] coins, int remainingAmount, Map<Integer,Integer> cache) {
        if (remainingAmount == 0) return 0;
        else if (cache.containsKey(remainingAmount)) {
            return cache.get(remainingAmount);
        } else {
            int min_coins = (int) Math.pow(10,9);
            for (int coin : coins) {
                if (coin <= remainingAmount) {
                    min_coins = Math.min(min_coins, 1 + recurrence(coins, remainingAmount - coin, cache));
                }
            }
            cache.put(remainingAmount, min_coins);
            return min_coins;
        }
    }

    // Bottom up - DP
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
