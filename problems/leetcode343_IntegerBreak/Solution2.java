package leetcode343_IntegerBreak;

class Solution2 {
  private int[] memo = new int[59];

  public int integerBreak(int n) {
    // memo[i] means the result of integer break of i;
    memo[1] = 1;
    memo[2] = 1;
    int maxValue;
    if (memo[n] != 0) return memo[n];
    for (int i = 3; i < n + 1; i++) {
      maxValue = 0;
      for (int j = 1; j < i; j++) {
        maxValue = max3(maxValue, j * (i - j), j * memo[i - j]);
      }
      memo[i] = maxValue;
    }

    return memo[n];
  }

  private int max3(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().integerBreak(10));
  }
}
