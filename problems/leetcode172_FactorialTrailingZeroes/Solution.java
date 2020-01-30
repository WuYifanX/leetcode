package leetcode172_FactorialTrailingZeroes;

class Solution {
  public int trailingZeroes(int n) {
    int fiveTimes = 0;
    while (n > 0) {
      fiveTimes += n / 5;
      n = n / 5;
    }
    return fiveTimes;
  }
}
