package leetcode322_CoinChange;

import java.util.Arrays;

class Solution {
  private int[] memo;

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) return 0;
    memo = new int[amount + 1];
    memo[0] = 0;
    Arrays.fill(memo, -1);

    innerCoinChange(coins, amount);

    return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
  }

  private int innerCoinChange(int[] coins, int amount) {
    if (amount < 0) return Integer.MAX_VALUE;
    if (amount == 0) {
      return 0;
    }

    if (memo[amount] != -1) return memo[amount];

    int min = Integer.MAX_VALUE;
    for (int i = coins.length - 1; i >= 0; i--) {
      int result = innerCoinChange(coins, amount - coins[i]);
      if (result == Integer.MAX_VALUE) continue;
      min = Math.min(min, result + 1);
    }

    memo[amount] = min;
    return memo[amount];
  }

  public static void main(String[] args) {

    System.out.println(new Solution().coinChange(new int[] {186, 419, 83, 408}, 6249));
  }
}
