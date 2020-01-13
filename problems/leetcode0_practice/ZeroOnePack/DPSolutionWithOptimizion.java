package leetcode0_practice.ZeroOnePack;

// 使用2层, 奇偶来压缩.
public class DPSolutionWithOptimizion {

  // [考虑第n层][capacity数量]
  private int[][] dp;

  public int knapsack01(int[] weight, int[] value, int capacity) {

    int n = weight.length;
    dp = new int[2][capacity + 1];

    return bestValue(weight, value, n - 1, capacity);
  }

  private int bestValue(int[] weight, int[] value, int n, int capacity) {
    if (n < 0 || capacity <= 0) return 0;

    for (int i = 0; i <= capacity; i++) {
      dp[0][i] = i >= weight[0] ? value[0] : 0;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= capacity; j++) {
        dp[i % 2][j] = dp[(i - 1) % 2][j];

        if (j >= weight[i]) {
          dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - weight[i]] + value[i]);
        }
      }
    }

    return dp[(n - 1) % 2][capacity];
  }
}
