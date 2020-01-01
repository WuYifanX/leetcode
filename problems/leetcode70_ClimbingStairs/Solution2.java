package leetcode70_ClimbingStairs;

public class Solution2 {
  private int[] memo;

  public int climbStairs(int n) {
    memo = new int[n + 1];
    return climbStairsRecursive(n);
  }

  private int climbStairsRecursive(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    if (memo[n] == 0) {
      memo[n] = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }
    return memo[n];
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().climbStairs(3));

  }
}
