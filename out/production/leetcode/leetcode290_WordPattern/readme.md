# Leetcode

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.

# Solution

1. 还是得注意审题, 在abba, dog dog dog dog也是不行的. 也就是说,一个pattern的字符只能对应一种模式. 不然边缘case挂掉比较可惜.


```java
package leetcode290_WordPattern;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] strArray = str.split(" ");
    if (strArray.length != pattern.length()) {
      return false;
    }

    String[] charDict = new String[26];
    int charDictIndex;
    for (int i = 0; i < pattern.length(); i++) {
      charDictIndex = pattern.charAt(i) - 'a';
      if (charDict[charDictIndex] == null) {
        if (isWordAlreadySavedInDict(charDict, strArray[i])) {
          return false;
        } else {
          charDict[charDictIndex] = strArray[i];
        }
      } else {
        if (!charDict[charDictIndex].equals(strArray[i])) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isWordAlreadySavedInDict(String[] dict, String word) {
    for (int i = 0; i < dict.length; i++) {
      if (dict[i] != null && dict[i].equals(word)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
  }
}


```
