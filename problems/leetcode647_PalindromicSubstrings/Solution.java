package leetcode647_PalindromicSubstrings;

class Solution {
  private int result = 0;

  public int countSubstrings(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();

    for (int i = 0; i < s.length(); i++) {
      // count for odd situation;
      countSubStrings(s, i - 1, i + 1);
      countSubStrings(s, i, i + 1);
    }

    return result + s.length();
  }

  private void countSubStrings(String s, int prevIndex, int postIndex) {
    while (prevIndex >= 0 && postIndex <= s.length() - 1) {
      if (s.charAt(prevIndex) != s.charAt(postIndex)) {
        return;
      }
      result++;
      prevIndex--;
      postIndex++;
    }
  }
}
