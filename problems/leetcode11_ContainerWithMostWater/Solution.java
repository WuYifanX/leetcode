package leetcode11_ContainerWithMostWater;

public class Solution {
  public int maxArea(int[] height) {
    int leftCursor = 0, rightCursor = height.length - 1;
    int maxArea = 0;

    while (leftCursor < rightCursor) {
      maxArea = Math.max(maxArea, calculateArea(height, leftCursor, rightCursor));
      if (height[leftCursor] > height[rightCursor]) {
        rightCursor--;
      } else{
        leftCursor++;
      }
    }
    return maxArea;
  }

  private int calculateArea(int[] height, int left, int right) {
    int heightNumber = Math.min(height[left], height[right]);
    return heightNumber * (right - left);
  }

  public static void main(String[] args) {
//        int[] inputs = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int[] inputs = new int[] {2, 3, 10, 5, 7, 8, 9};
    System.out.println(new Solution().maxArea(inputs));
  }
}
