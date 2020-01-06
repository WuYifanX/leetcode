package leetcode131_PalindromePartitioning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

  private List<List<String>> result = new ArrayList<>();
  private Deque<String> stack;
  private boolean[][] dp;

  public List<List<String>> partition(String s) {
    if (s.length() == 0) return result;

    buildDPForPalindrome(s);
    stack = new ArrayDeque<>();
    innerPartition(s, 0);
    return result;
  }

  private void buildDPForPalindrome(String s) {
    dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      // the reason for j <= i is that
      // when we use dp[i][j] we can make sure that i <=j;
      for (int j = 0; j <= i; j++) {
        if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
          dp[j][i] = true;
        }
      }
    }
  }

  private void innerPartition(String s, int start) {
    if (start == s.length()) {
      result.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      if (!dp[start][i]) {
        continue;
      }
      stack.addLast(s.substring(start, i + 1));
      innerPartition(s, i + 1);
      stack.removeLast();
    }
  }

  public static void main(String[] args) {
    List<List<String>> aab = new Solution2().partition("dd");
    System.out.println(aab);
  }
}
