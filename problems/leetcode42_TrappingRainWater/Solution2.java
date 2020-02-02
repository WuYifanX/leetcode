package leetcode42_TrappingRainWater;

class Solution2 {
  public int trap(int[] height) {
    if (height.length <= 2) return 0;
    int result = 0;

    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];

    leftMax[0] = 0;
    for (int i = 1; i < leftMax.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
    }

    rightMax[height.length - 1] = 0;
    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
    }

    for (int i = 1; i < height.length - 1; i++) {
      int currentHeight = Math.min(leftMax[i], rightMax[i]);
      if (currentHeight > height[i]) {
        result += currentHeight - height[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Solution2().trap(a));
  }
}
