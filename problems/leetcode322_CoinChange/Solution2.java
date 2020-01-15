package leetcode322_CoinChange;

import java.util.Arrays;

class Solution2 {

  public int coinChange(int[] coins, int amount) {

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[0] = 0;

    // 这里的i表示目前的min个数.
    for (int i = 1; i < amount + 1; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] < 0) continue;
        min = Math.min(min, dp[i - coins[j]]);
      }

      if (min != Integer.MAX_VALUE) dp[i] = min + 1;
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

  public static void main(String[] args) {

    System.out.println(new Solution2().coinChange(new int[] {186, 419, 83, 408}, 6249));
  }
}
