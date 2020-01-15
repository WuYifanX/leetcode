package leetcode139_WordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private Set<String> wordSet;
  private Set<Integer> lengthSet;

  // [i, s.length -1] can be break or not.
  private int[] memo;

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s.length() == 0 || wordDict.size() == 0) return false;

    wordSet = new HashSet<>(wordDict);
    lengthSet = new HashSet<>();
    for (String word : wordDict) {
      lengthSet.add(word.length());
    }

    memo = new int[s.length() + 1];
    memo[s.length()] = 1;

    innerWordBreak(s, 0, s.length() - 1);
    return memo[0] == 1;
  }

  // [start, end]
  private int innerWordBreak(String s, int start, int end) {
    if (start == end + 1) return 1;
    if (start > end + 1) return -1;

    if (memo[start] != 0) return memo[start];
    int result = -1;
    for (int length : lengthSet) {
      if (start + length > end + 1) continue;

      String currentWord = s.substring(start, start + length);
      if (wordSet.contains(currentWord) && innerWordBreak(s, start + length, end) == 1) {
        result = 1;
        break;
      }
    }

    memo[start] = result;

    return memo[start];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
  }
}
