package leetcode64_MinimumPathSum;

import java.util.Arrays;

public class Solution2 {
  public int minPathSum(int[][] grid) {
    int m = grid.length + 1;
    int n = grid[0].length + 1;
    // definition
    // dp[i][j] means the mini path sum of point (i, j);

    // init the matrix.
    int[][] dp = new int[m][n];

    // filled with max value;
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    dp[1][1] = grid[0][0];

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (i == 1 && j == 1) continue;
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
      }
    }

    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(new Solution2().minPathSum(input));
  }
}
