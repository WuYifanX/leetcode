package leetcode309_BestTimetoBuyandSellStockwithCooldown;

class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;

    // dp[m][n] m is the maxprofit from in range[0,...m].
    // n is the status that hold the stock or not.
    // 0 is not hold the stock. 1 is holding the stock.
    int[][] dp = new int[prices.length][2];

    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      if (i >= 2) {
        // dp[i - 1][1] 是昨天就买了, 今天不动
        // dp[i - 1][0] - prices[i] 是昨天没有, 今天买.但是这种情况中的有一种条件不对.
        // 一种是昨天卖了, 需要cooldown, 那不能买, 需要排除.
        // 一种是今天买的, 昨天是cooldown, 前天是拥有股票, 然后卖了.
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0]  - prices[i]);
      } else {
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
      }
    }

    return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
  }
}

// [2,1,4]
// [1,2,3,0,2]
// [6,1,6,4,3,0,2]
