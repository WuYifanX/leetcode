# Leetcode

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


# Solution

1. 滑动窗口, 使用set;

2. 再使用map的时候, 我们可以知道需要移动到哪儿, 类似于KMP算法;

```java
package leetcode3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();

    Set<Character> set = new HashSet<>();
    int left = 0;
    int right = 1;
    int result = 1;
    set.add(s.charAt(0));

    while (right < s.length()) {
      if (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      } else {
        set.add(s.charAt(right));
        result = Math.max(result, right - left + 1);
        right++;
      }
    }

    return result;
  }
}

```


```java
package leetcode3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();

    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 1;
    int result = 1;
    map.put(s.charAt(0), 0);

    while (right < s.length()) {
      if (map.containsKey(s.charAt(right))) {
        int nextIndex = map.get(s.charAt(right)) + 1;
        while (left != nextIndex) {
          map.remove(s.charAt(left));
          left++;
        }
        map.put(s.charAt(right), right);
      } else {
        map.put(s.charAt(right), right);
        result = Math.max(result, right - left + 1);
      }
      right++;
    }

    return result;
  }
}

```
