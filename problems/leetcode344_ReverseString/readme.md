# Leetcode

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

```
Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

# Solution

```java
package leetcode344_ReverseString;

class Solution {
  public void reverseString(char[] s) {
    if (s.length == 0 || s.length == 1) return;

    int pIndex = 0;
    int qIndex = s.length - 1;

    while (pIndex < qIndex) {
      swap(s, pIndex, qIndex);
      qIndex--;
      pIndex++;
    }
  }

  private void swap(char[] s, int p, int q) {
    char temp = s[p];
    s[p] = s[q];
    s[q] = temp;
  }

  public static void main(String[] args) {
    char[] a = new char[] {'h', 'e', 'l', 'l', 'o'};
    new Solution().reverseString(a);
    System.out.println(a);
  }
}

```
