# Leetcode

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.


# Solution

1. 因为负数的存在, 负数Integer.MIN_VALUE 是比正数Integer.MAX_VALUE大1的.
所以没办法转化成为正数计算, 所以这里全部都转化成为了负数.

2. 在做while循环的时候,` temp = temp << 1 `容易溢出, 所以需要判断是否溢出.溢出了的话, 就直接跳出去.

```java
class Solution {
  public int divide(int dividend, int divisor) {
    boolean isPositive = false;
    if ((divisor < 0 && dividend < 0) || (dividend > 0 && divisor > 0)) {
      isPositive = true;
    }

    if (dividend > 0) dividend = -dividend;
    if (divisor > 0) divisor = -divisor;

    if (divisor == -1) return calculatePositiveOrNegative(dividend, isPositive);
    if (dividend == divisor) return calculatePositiveOrNegative(-1, isPositive);
    if (dividend > divisor) return 0;

    int quotient = -1;
    int temp = divisor;

    while (temp << 1 < 0 && temp << 1 > dividend) {
      quotient = quotient << 1;
      temp = temp << 1;
    }

    if (temp == dividend) return calculatePositiveOrNegative(quotient, isPositive);

    int unsignedResult = quotient - divide(dividend - temp, divisor);

    return calculatePositiveOrNegative(unsignedResult, isPositive);
  }

  private int calculatePositiveOrNegative(int unsignedResult, boolean isPositive) {
    if (isPositive) {
      if (unsignedResult == Integer.MIN_VALUE) return Integer.MAX_VALUE;
      return -unsignedResult;
    }
    return unsignedResult;
  }
}

```
