# Leetcode

Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?


# Solution

1. 一般这种情况都能通过枚举实现.1162261467是int的最大Math.pow(3,19);

```java
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;
    }
}

```
