# Leetcode


Given a 32-bit signed integer, reverse digits of an integer.

```

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


```
# Solution

这个result可能会溢出, 这里很巧妙的是先转化成为long
然后再转回去看有没有溢出.

```java
package leetcode7_ReverseInteger;

class Solution {
  public int reverse(int x) {
    long result = 0;

    while (x != 0) {
      result = result * 10 + x % 10;
      x = x / 10;
    }

    return (int) result == result ? (int) result : 0;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reverse(123));
  }
}

```
