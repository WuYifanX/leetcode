# Leetcode

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


# Solution:

1. Solution1 使用hashmap.
2. Solution2 使用一个int[] 数组解决.
3. 也可以排序了之后比较每个字.

```java


public class Solution2 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a'] += 1;
      count[t.charAt(i) - 'a'] -= 1;
    }

    for (int j = 0; j < 26; j++) {
      if (count[j] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().isAnagram("anagram", "nagaram"));
    System.out.println(new Solution2().isAnagram("atagram", "nagaram"));
  }
}
```
