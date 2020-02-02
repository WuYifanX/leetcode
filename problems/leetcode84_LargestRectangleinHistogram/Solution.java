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
