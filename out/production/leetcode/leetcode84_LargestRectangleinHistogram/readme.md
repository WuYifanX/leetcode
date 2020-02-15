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

2. 使用栈来处理:可以参考这里的解答.
https://blog.csdn.net/Zolewit/article/details/88863970

主要思路是利用一个单调栈, 这个栈保存了i之前的所有的单调增的值.
然后计算之前所有的可能值. 也就是i之前的单调值和i形成的面积.

```java
package leetcode84_LargestRectangleinHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>();

    int result = 0;
    // -1 表示0之前的一个index.
    stack.addFirst(-1);

    for (int i = 0; i < heights.length; i++) {
      // 计算之单调栈里面面积. 选择最大值.
      while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
        result = Math.max(result, heights[stack.pop()] * (i - stack.peekFirst() - 1));
      }
      // 这个是i前面的单调栈.
      stack.addFirst(i);
    }

    // 最后清空stack的面积.
    while (stack.peekFirst() != -1) {
      result = Math.max(result, heights[stack.pop()] * (heights.length - stack.peekFirst() - 1));
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[] {2, 1, 5, 6, 2, 3};
    System.out.println(new Solution2().largestRectangleArea(a));
  }
}

```
