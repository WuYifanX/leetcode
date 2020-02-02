# Leetcode

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.


Example:

Input: [2,1,5,6,2,3]
Output: 10


# Solution

1. 暴力破解: 二维数组已经超过了空间复杂的. 然后可以降低成为一维

```java
package leetcode84_LargestRectangleinHistogram;

class Solution {
  public int largestRectangleArea(int[] heights) {
    int largestArea = 0;
    int[] minHeightBetween = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      for (int j = i; j < heights.length; j++) {
        if (i == j) {
          minHeightBetween[j] = heights[i];
        } else {
          minHeightBetween[j] = Math.min(minHeightBetween[j - 1], heights[j]);
        }

        largestArea = Math.max(largestArea, minHeightBetween[j] * (j - i + 1));
      }
    }
    return largestArea;
  }
}

```
