# Leetcode

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]

# Solution

1. 有几个边缘的case: n = Integer.MAX, Integer.MIN的时候, 可能会溢出
特别是 -2147483648的时候, 变正的时候就会溢出了. 所以这里有-(n + 1);

```java
class Solution {
  public double myPow(double x, int n) {
    if (n == 0 || x == 1f) return 1f;

    if (n < 0) {
      return (1 / x) * myPow(1 / x, -(n + 1));
    }

    if (n % 2 == 0) {
      double temp = myPow(x, n / 2);
      return temp * temp;
    }
    return x * myPow(x, n - 1);
  }
}

```
