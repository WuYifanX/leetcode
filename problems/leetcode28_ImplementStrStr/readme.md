# Leetcode

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


# Solution

通过这里来复习下BM, KMP

```java

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

```
