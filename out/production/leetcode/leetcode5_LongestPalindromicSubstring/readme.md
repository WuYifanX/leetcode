# Leetcode

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

# Solution

1. Solution1: 暴力破解, n^3. 有优化的空间.就是从最大的长度开始暴力.
2. Solution2: DP: 还可以压缩空间复杂的. 因为只用到了附近的数据.

```java
package leetcode5_LongestPalindromicSubstring;

class Solution2 {

  public String longestPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) return s;

    boolean[][] dp = new boolean[s.length()][s.length()];
    String longest = s.charAt(0) + "";
    int maxLength = 1;
    boolean isChangedLastLoop;

    // init the dp;
    for (int i = 0; i < dp.length; i++) {
      dp[i][i] = true;
      if (i < dp.length - 1 && s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        if (maxLength < 2) {
          maxLength = 2;
          longest = s.substring(i, i + 2);
        }
      }
    }

    for (int len = 3; len <= s.length(); len++) {
      isChangedLastLoop = false;
      for (int i = 0; i < s.length() - len + 1; i++) {
        if (s.charAt(i) == s.charAt(i + len - 1) && dp[i + 1][i + len - 2]) {
          isChangedLastLoop = true;
          dp[i][i + len - 1] = true;
          if (maxLength < len) {
            maxLength = len;
            longest = s.substring(i, i + len);
          }
        }
      }
      if (!isChangedLastLoop) {
        break;
      }
    }

    return longest;
  }
}

```

