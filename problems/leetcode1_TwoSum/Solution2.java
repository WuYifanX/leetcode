package leetcode1_TwoSum;

public class Solution2 {

  private int[] memo;

  public int getRabbit(int n) {
    if (n == 0) return 0;
    memo = new int[n + 1];
    memo[1] = 1;
    memo[2] = 1;

    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    }

    return memo[n];
  }

}
