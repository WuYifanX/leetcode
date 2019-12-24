# Leetcode
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".


# Solution:

1. 基于242_validAnagram的基础上, 来使用滑动窗口解决

```java
package leetcode438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.Logs;

public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    if (s.length() < p.length()) {
      return Collections.emptyList();
    }
    List<Integer> res = new ArrayList<>();

    int lowerCursor = 0;
    int higherCursor = p.length() - 1;
    int targetASCISUM = getASCIISUM(p, 0, p.length() - 1);
    int windowASCISUM = getASCIISUM(s, lowerCursor, higherCursor);

    while (true) {
      if (windowASCISUM == targetASCISUM && isAnagrams(s, lowerCursor, higherCursor, p)) {
        res.add(lowerCursor);
      }

      if (higherCursor == s.length() - 1) {
        break;
      }

      windowASCISUM -= s.charAt(lowerCursor) - 'a';
      lowerCursor++;
      higherCursor++;
      windowASCISUM += s.charAt(higherCursor) - 'a';
    }

    return res;
  }

  private int getASCIISUM(String s, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += s.charAt(i) - 'a';
    }
    return sum;
  }

  public boolean isAnagrams(String s, int start, int end, String p) {
    if (end - start + 1 != p.length()) {
      return false;
    }

    int[] count = new int[26];

    for (int i = start; i <= end; i++) {
      count[s.charAt(i) - 'a'] += 1;
    }

    for (int j = 0; j < p.length(); j++) {
      count[p.charAt(j) - 'a'] -= 1;
    }

    for (int k = 0; k < 26; k++) {
      if (count[k] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Logs.print(new Solution().findAnagrams("baa", "aa"));
    //    System.out.println(new Solution().isAnagrams(input, 5, 19, target));
  }
}

```
