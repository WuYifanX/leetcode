# Leetcode

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

```
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


```
# Solution

记忆化搜索; 一纬memo来表示 memo[i] 表示[i, s.length -1]能够被分解与否.


```java
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

```
