package leetcode96_UniqueBinarySearchTrees;

class Solution {
  public int numTrees(int n) {
    if (n == 0 || n == 1) return n;

    // dp[i]表示i的全部的个数.
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().numTrees(3));
  }
}
