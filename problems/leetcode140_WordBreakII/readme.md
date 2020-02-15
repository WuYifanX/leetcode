# Leetcode

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

```
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
```


# Solution

最重要的是定义清楚wordBreakRec和memo的定义, 特别是传入和返回.
然后严格按照定义去写代码

```java
package leetcode140_WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  private Set<String> dict;
  // all possible result in current index.
  private Map<Integer, List<String>> memo = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    dict = new HashSet<>(wordDict);
    List<String> result = wordBreakRec(s, 0);
    if (result == null) return new ArrayList<>();
    return result;
  }

  // return all possible list result.
  private List<String> wordBreakRec(String s, int start) {
    if (s.length() == start) {
      return new ArrayList<>();
    }

    List<String> resultForStartIndex = new ArrayList<>();

    String head;
    List<String> recResult;
    for (int i = start + 1; i <= s.length(); i++) {
      head = s.substring(start, i);
      if (dict.contains(head)) {
        if (memo.containsKey(i) && memo.get(i) == null) continue;

        if (!memo.containsKey(i)) {
          recResult = wordBreakRec(s, i);
          if (recResult == null) {
            memo.put(i, null);
          } else if (recResult.size() == 0) {
            resultForStartIndex.add(head);
          } else {
            for (String temp : recResult) {
              resultForStartIndex.add(head + " " + temp);
            }
          }
        } else {
          for (String temp : memo.get(i)) {
            resultForStartIndex.add(head + " " + temp);
          }
        }
      }
    }

    if (resultForStartIndex.size() == 0) {
      return null;
    } else {
      memo.put(start, resultForStartIndex);
      return resultForStartIndex;
    }
  }

  public static void main(String[] args) {
    List<String> a = Arrays.asList("cat", "cats", "and", "sand", "dog");
    System.out.println(new Solution().wordBreak("catsanddog", a));
  }
}

```
