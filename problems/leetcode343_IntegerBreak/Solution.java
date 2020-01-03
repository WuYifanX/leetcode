package leetcode343_IntegerBreak;

class Solution {
  private int[] memo = new int[59];

  public int integerBreak(int n) {
    // memo[i] means the result of integer break of i;
    memo[1] = 1;
    memo[2] = 1;

    return calculateMaxBreak(n);
  }

  public int calculateMaxBreak(int n) {
    if (memo[n] != 0) return memo[n];
    int maxValue = 0;
    int temp;
    for (int i = 1; i < n; i++) {
      temp = Math.max(i * calculateMaxBreak(n - i), i * (n - i));
      maxValue = Math.max(temp, maxValue);
    }
    memo[n] = maxValue;
    return memo[n];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().integerBreak(2));
  }
}
