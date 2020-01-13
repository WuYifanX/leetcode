package leetcode0_practice.ZeroOnePack;

public class RecursiveSolution {

  private int[][] dp;

  public int knapsack01(int[] weight, int[] value, int capacity) {

    int n = weight.length;
    dp = new int[n][capacity];
    return bestValue(weight, value, n - 1, capacity);
  }

  private int bestValue(int[] weight, int[] value, int index, int capacity) {

    if (index < 0 || capacity <= 0) return 0;

    if (dp[index][capacity] != 0) return dp[index][capacity];

    // do not choose this index one;
    int result = bestValue(weight, value, index - 1, capacity);

    if (weight[index] <= capacity) {
      result =
          Math.max(
              result, value[index] + bestValue(weight, value, index - 1, capacity - weight[index]));
    }
    dp[index][capacity] = result;
    return result;
  }
}
