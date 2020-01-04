package leetcode62_UniquePaths;

class Solution {
  public int uniquePaths(int m, int n) {
    if (n == 0 || m == 0) return 0;
    int[][] dp = new int[2][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i % 2][j] = 1;
          continue;
        }
        dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
      }
    }

    return dp[(m - 1) % 2][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().uniquePaths(3, 7));
  }
}
