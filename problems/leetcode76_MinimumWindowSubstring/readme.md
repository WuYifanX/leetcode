# Leetcode

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


# Thoughts:

需要考虑:

1. 使用map的时候, 自动装箱过程.
2. 使用int[] 的效率还是高于hashmap;
3. 遍历数组肯定比遍历t的效率更高, 这也是containTargetCharacters的改进

# Solution1:

使用hashmap的solution1超时, 使用int[]效率好了点.


```java
// solution1
package leetcode76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private Map<Character, Integer> targetMap = new HashMap<>();

  public String minWindow(String s, String t) {
    for (char c : t.toCharArray()) {
      targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
    }

    int lowCursor = 0, highCursor = -1;
    int minLowCursor = 0, minHighCursor = -1;
    int minCount = s.length() + 1;
    boolean isTIncluded = false;

    while (highCursor < s.length() && lowCursor < s.length()) {

      // 只有在不包含t的字符和没有达到最后的一位的时候才需要变化
      while (highCursor < s.length() - 1 && !isTIncluded) {
        highCursor++;
        char currentChar = s.charAt(highCursor);

        if (targetMap.containsKey(currentChar)) {
          targetMap.put(currentChar, targetMap.get(currentChar) - 1);
          if (containTargetCharacters(t)) {
            isTIncluded = true;
          }
        }
      }

      while (isTIncluded && lowCursor < s.length()) {
        if (highCursor - lowCursor + 1 < minCount) {
          minHighCursor = highCursor;
          minLowCursor = lowCursor;
          minCount = highCursor - minLowCursor + 1;
        }
        char currentChar = s.charAt(lowCursor);
        if (targetMap.containsKey(currentChar)) {
          targetMap.put(currentChar, targetMap.get(currentChar) + 1);
          if (!containTargetCharacters(t)) {
            isTIncluded = false;
          }
        }
        lowCursor++;
      }

      if (highCursor == s.length() - 1) {
        break;
      }
    }

    char[] result = new char[minCount];
    if (minCount != s.length() + 1) {
      for (int i = minLowCursor; i <= minHighCursor; i++) {
        result[i - minLowCursor] = s.charAt(i);
      }
    }
    return minCount != s.length() + 1 ? new String(result) : "";
  }

  public boolean containTargetCharacters(String t) {
    for (char c : t.toCharArray()) {
      if (targetMap.get(c) > 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
DPSolution
  }
}

```

```java
package leetcode76_MinimumWindowSubstring;

public class Solution2 {

  private int[] targetMap = new int[64];
  private final int nullNumber = -126;

  public String minWindow(String s, String t) {

    for (int i = 0; i < 64; i++) {
      targetMap[i] = nullNumber;
    }

    for (char c : t.toCharArray()) {
      if (targetMap[c - 'A'] == nullNumber) {
        targetMap[c - 'A'] = 0;
      }

      targetMap[c - 'A'] += 1;
    }

    int lowCursor = 0, highCursor = -1;
    int minLowCursor = 0, minHighCursor = -1;
    int minCount = s.length() + 1;
    boolean isTIncluded = false;

    while (highCursor < s.length() && lowCursor < s.length()) {

      // 只有在不包含t的字符和没有达到最后的一位的时候才需要变化
      while (highCursor < s.length() - 1 && !isTIncluded) {
        highCursor++;
        char currentChar = s.charAt(highCursor);

        if (targetMap[currentChar - 'A'] != nullNumber) {
          targetMap[currentChar - 'A'] -= 1;
          if (containTargetCharacters(t)) {
            isTIncluded = true;
          }
        }
      }

      while (isTIncluded && lowCursor < s.length()) {
        if (highCursor - lowCursor + 1 < minCount) {
          minHighCursor = highCursor;
          minLowCursor = lowCursor;
          minCount = highCursor - minLowCursor + 1;
        }
        char currentChar = s.charAt(lowCursor);
        if (targetMap[currentChar - 'A'] != nullNumber) {
          targetMap[currentChar - 'A'] += 1;
          if (!containTargetCharacters(t)) {
            isTIncluded = false;
          }
        }
        lowCursor++;
      }

      if (highCursor == s.length() - 1) {
        break;
      }
    }

    char[] result = new char[minCount];
    if (minCount != s.length() + 1) {
      for (int i = minLowCursor; i <= minHighCursor; i++) {
        result[i - minLowCursor] = s.charAt(i);
      }
    }
    return minCount != s.length() + 1 ? new String(result) : "";
  }

  public boolean containTargetCharacters(String t) {
    for( int i =0; i< 64; i++){
      if(targetMap[i] > 0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().minWindow("cabwefgewcwaefgcf", "cae"));
    DPSolution
  }
}


```
