# Leetcode

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.


# Solution

这里需要考虑int溢出的问题.
因为最大的Integer.MAX_VALUE 的Sqrt是46340. 所以这里可以从这个为rightLimit开始找.

```java
package leetcode69_Sqrtx;

class Solution {
  public int mySqrt(int x) {
    if (x == 0) return 0;

    int rightLimit = 46340;
        if (x > rightLimit) {
          return binarySearch(1, rightLimit, x);
        } else {
          return binarySearch(1, x, x);
        }
  }

  private int binarySearch(int left, int right, int targetSquare) {
    if (left >= right) {
      if (right * right <= targetSquare) return right;
      return right - 1;
    }

    int middle = (right - left) / 2 + left;

    long middleSquare = middle * middle;
    if (middleSquare == targetSquare) return middle;
    if (middleSquare > targetSquare) {
      return binarySearch(left, middle - 1, targetSquare);
    } else {
      return binarySearch(middle + 1, right, targetSquare);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(8));
  }
}

```
