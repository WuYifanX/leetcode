# Leetcode

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.


# Solution

```java
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

```


Solution2 dp: 

```java

import java.util.Arrays;

class Solution {

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
}

```
