package leetcode131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<List<String>> result = new ArrayList<>();

  public List<List<String>> partition(String s) {
    if (s.length() == 0) return result;
    innerPartition(s, new ArrayList<>());
    return result;
  }

  private void innerPartition(String s, List<String> resultElement) {
    if (s.length() == 0) result.add(resultElement);
    for (int i = 0; i < s.length(); i++) {
      List<String> newResultForEachLoop = new ArrayList<>(resultElement);
      String fixed = s.substring(0, i + 1);
      if (!isPalindrome(fixed)) continue;
      String rest = s.substring(i + 1);
      newResultForEachLoop.add(fixed);
      innerPartition(rest, newResultForEachLoop);
    }
  }

  private boolean isPalindrome(String fixed) {
    if (fixed.length() == 1 || fixed.length() == 0) return true;
    int left = 0;
    int right = fixed.length() - 1;

    while (left < right) {
      if (fixed.charAt(left) != fixed.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    List<List<String>> aab = new Solution().partition("dd");
    System.out.println(aab);
  }
}
