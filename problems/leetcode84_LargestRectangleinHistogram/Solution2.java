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
