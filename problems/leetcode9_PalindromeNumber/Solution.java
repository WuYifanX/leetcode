package leetcode9_PalindromeNumber;

class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    if (x < 10) return true;

    int y = x;
    int z = 0;

    while (y != 0) {
      z = z * 10 + y % 10;
      y = y / 10;
    }

    return x == z;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(1221));
  }
}
