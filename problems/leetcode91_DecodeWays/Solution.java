package leetcode91_DecodeWays;

import java.util.Arrays;

public class Solution {
  private int[] memo;

  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) return 0;
    memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return calculateDecodings(s, 0, s.length() - 1);
  }

  private int calculateDecodings(String s, int i, int j) {
    if (i > j) {
      return 1;
    }
    if (s.charAt(i) == '0') return 0;
    if (i == j) return 1;

    if (memo[i] != -1) return memo[i];
    int resultForIndexI;

    int number = Integer.valueOf(s.substring(i, i + 2));

    if (number > 26) {
      resultForIndexI = calculateDecodings(s, i + 1, j);
    } else {
      resultForIndexI = calculateDecodings(s, i + 1, j) + calculateDecodings(s, i + 2, j);
    }

    memo[i] = resultForIndexI;
    return resultForIndexI;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().numDecodings("100"));
  }
}
