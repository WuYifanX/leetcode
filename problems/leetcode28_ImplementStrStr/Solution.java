package leetcode28_ImplementStrStr;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    if (haystack.length() == 0) return -1;
    if (haystack.length() < needle.length()) return -1;

    Set<String> set = new HashSet<>(1);

    set.add(needle);
    String current;
    int length = needle.length();
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      current = haystack.substring(i, i + length);
      if (set.contains(current)) return i;
    }
    return -1;
  }
}
