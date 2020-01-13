package leetcode0_practice.ZeroOnePack;

public class DPSolution {

  // [考虑第n层][capacity数量]
  private int[][] dp;

  public int knapsack01(int[] weight, int[] value, int capacity) {

    int n = weight.length;
    dp = new int[n][capacity + 1];

    return bestValue(weight, value, n - 1, capacity);
  }

  private int bestValue(int[] weight, int[] value, int n, int capacity) {
    if (n < 0 || capacity <= 0) return 0;

    for (int i = 0; i <= capacity; i++) {
      dp[0][i] = i >= weight[0] ? value[0] : 0;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= capacity; j++) {
        dp[i][j] = dp[i - 1][j];

        if (j >= weight[i]) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
        }
      }
    }

    return dp[n - 1][capacity];
  }
}
