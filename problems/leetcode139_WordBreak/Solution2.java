package leetcode139_WordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {

  private Set<String> dict;
  private boolean[] triedArray;

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s.length() == 0) return true;
    if (wordDict.size() == 0) return false;
    dict = new HashSet<>(wordDict);
    triedArray = new boolean[s.length() + 1];

    return wordBreakRec(s, 0);
  }

  private boolean wordBreakRec(String s, int start) {
    if (triedArray[start]) return false;

    String head, tail;
    for (int i = start + 1; i <= s.length(); i++) {
      head = s.substring(start, i);
      if (dict.contains(head)) {
        tail = s.substring(i);
        if (tail.length() == 0 || dict.contains(tail) || wordBreakRec(s, i)) {
          return true;
        }
        triedArray[i] = true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().wordBreak("abc", Arrays.asList("a", "b", "c")));
  }
}
