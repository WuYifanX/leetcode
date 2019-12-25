# Leetcode

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.


# Solution

1. 在没有定义大小写和数字的时候,一定是全部都可能, 数组选择128.如果只有大小写可以选64

```java

package leetcode205_IsomorphicStrings;

class Solution {
  public boolean isIsomorphic(String s, String t) {
    Character[] charDict = new Character[128];
    char sChar;
    char tChar;

    for (int i = 0; i < s.length(); i++) {
      sChar = s.charAt(i);
      tChar = t.charAt(i);
      if (charDict[sChar] == null) {
        if (isCharacterAlreadySavedInDict(charDict, tChar)) {
          return false;
        } else {
          charDict[sChar] = tChar;
        }
      } else {
        if (charDict[sChar] != tChar) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isCharacterAlreadySavedInDict(Character[] dict, Character tChar) {
    for (int i = 0; i < dict.length; i++) {
      if (dict[i] != null && dict[i] == (tChar)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isIsomorphic("egg", "add"));
    System.out.println(new Solution().isIsomorphic("foo", "bar"));
    System.out.println(new Solution().isIsomorphic("paper", "title"));
    System.out.println(new Solution().isIsomorphic("13", "42"));
  }
}

```
