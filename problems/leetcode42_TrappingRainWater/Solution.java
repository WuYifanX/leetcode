package leetcode42_TrappingRainWater;

class Solution {

  private class Indexs {
    public int secondLargestIndex;
    public int lowestIndex;

    private Indexs(int secondLargestIndex, int lowestIndex) {
      this.secondLargestIndex = secondLargestIndex;
      this.lowestIndex = lowestIndex;
    }
  }

  public int trap(int[] height) {
    if (height.length <= 2) return 0;
    int maxIndex = 0;

    for (int i = 1; i < height.length; i++) {
      if (height[i] > height[maxIndex]) maxIndex = i;
    }

    int result = 0;
    int maxIndexInRightPart = maxIndex;
    // calculate [maxIndex, height.length-1];
    while (true) {
      Indexs indexs = findSecondLargestAndLowestIndex(height, maxIndexInRightPart, true);
      if (indexs.secondLargestIndex >= height.length
          || indexs.secondLargestIndex <= indexs.lowestIndex) break;
      result += getArea(height, maxIndexInRightPart, indexs);
      maxIndexInRightPart = indexs.secondLargestIndex;
    }

    // calculate [0, maxIndex];
    while (true) {
      Indexs indexs = findSecondLargestAndLowestIndex(height, maxIndex, false);
      if (indexs.secondLargestIndex <= -1 || indexs.secondLargestIndex >= indexs.lowestIndex) break;
      result += getArea(height, maxIndex, indexs);
      maxIndex = indexs.secondLargestIndex;
    }

    return result;
  }

  private Indexs findSecondLargestAndLowestIndex(
      int[] height, int start, boolean positiveDirection) {
    int step = positiveDirection ? 1 : -1;

    int current = start + step;
    int secondLargestIndex = current;
    while (current != height.length && current != -1) {
      if (height[current] >= height[secondLargestIndex]) {
        secondLargestIndex = current;
      }
      current += step;
    }

    current = start + step;
    int lowestIndex = start;
    while (current != secondLargestIndex) {
      if (height[current] <= height[lowestIndex]) {
        lowestIndex = current;
      }
      current += step;
    }

    return new Indexs(secondLargestIndex, lowestIndex);
  }

  private int getArea(int[] height, int maxIndex, Indexs indexs) {
    int area = 0;
    int lowerIndex = Math.min(maxIndex, indexs.secondLargestIndex);
    int higherIndex = Math.max(maxIndex, indexs.secondLargestIndex);

    int heightValue = Math.min(height[maxIndex], height[indexs.secondLargestIndex]);
    for (int i = lowerIndex + 1; i < higherIndex; i++) {
      if (heightValue - height[i] > 0) area += heightValue - height[i];
    }
    return area;
  }

  public static void main(String[] args) {
    int[] a = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Solution().trap(a));
  }
}
