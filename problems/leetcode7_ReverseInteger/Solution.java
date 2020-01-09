package leetcode7_ReverseInteger;

class Solution {
  public int reverse(int x) {
    long result = 0;

    while (x != 0) {
      result = result * 10 + x % 10;
      x = x / 10;
    }

    return (int) result == result ? (int) result : 0;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reverse(123));
  }
}
