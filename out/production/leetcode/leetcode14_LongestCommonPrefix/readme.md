# Leetcode

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.


# Solution

```java
package leetcode14_LongestCommonPrefix;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

    StringBuilder sb = new StringBuilder();
    int currentIndex = 0;
    while (true) {
      for (int i = 0; i < strs.length; i++) {
        if (currentIndex < strs[i].length()) {
          if (i == 0) continue;

          if (strs[i - 1].charAt(currentIndex) != strs[i].charAt(currentIndex)) {
            return sb.toString();
          }
        } else {
          return sb.toString();
        }
      }
      sb.append(strs[0].charAt(currentIndex));
      currentIndex++;
    }
  }

  public static void main(String[] args) {
    String[] input = new String[] {"flower", "flow", "flight"};
    System.out.println(new Solution().longestCommonPrefix(input));
  }
}

```
