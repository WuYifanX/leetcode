package leetcode29_DivideTwoIntegers;

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
