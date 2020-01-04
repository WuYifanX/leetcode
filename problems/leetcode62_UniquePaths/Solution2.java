package leetcode62_UniquePaths;

import java.util.Arrays;

class Solution2 {
  public int uniquePaths(int m, int n) {
    if (n == 0 || m == 0) return 0;

    int less = Math.min(m, n);
    int more = Math.max(m, n);
    int[] dp = new int[less];

    Arrays.fill(dp, 1);
    for (int i = 1; i < more; i++) {
      for (int j = 1; j < less; j++) {
        dp[j] = dp[j] + dp[j - 1];
      }
    }
    return dp[less - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().uniquePaths(3, 7));
  }
}
