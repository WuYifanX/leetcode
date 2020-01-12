package leetcode5_LongestPalindromicSubstring;

class Solution {
  public String longestPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) return s;

    for (int i = s.length(); i >= 1; i--) {
      for (int j = 0; j < s.length() - i + 1; j++) {
        if (isPalindrome(s, j, j + i - 1)) {
          return s.substring(j, j + i);
        }
      }
    }

    return s;
  }

  // find palindrome in [start,end];
  private boolean isPalindrome(String s, int start, int end) {
    while (start <= end) {
      if (s.charAt(start) == s.charAt(end)) {
        start++;
        end--;
      } else {
        return false;
      }
    }

    return true;
  }


}
