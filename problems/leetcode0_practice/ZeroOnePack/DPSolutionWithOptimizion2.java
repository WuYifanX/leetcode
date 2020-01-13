package leetcode0_practice.ZeroOnePack;

public class DPSolutionWithOptimizion2 {

  // [capacity数量]
  private int[] dp;

  public int knapsack01(int[] weight, int[] value, int capacity) {

    int n = weight.length;
    dp = new int[capacity + 1];

    return bestValue(weight, value, n - 1, capacity);
  }

  private int bestValue(int[] weight, int[] value, int n, int capacity) {
    if (n < 0 || capacity <= 0) return 0;

    for (int i = 0; i <= capacity; i++) {
      dp[i] = i >= weight[0] ? value[0] : 0;
    }

    for (int i = 0; i < n; i++) {
      for (int j = capacity; j > 0; j--) {
        if (j >= weight[i]) {
          dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
      }
    }

    return dp[capacity];
  }
}
