package leetcode42_TrappingRainWater;

class Solution3 {
  public int trap(int[] height) {
    if (height.length <= 2) return 0;
    int result = 0;

    int left = 0;
    int right = height.length - 1;
    int leftMax = height[left];
    int rightMax = height[right];

    while (left < right) {
      if (height[left] <= height[right]) {

        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          result += leftMax - height[left];
        }
        left++;

      } else {

        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          result += rightMax - height[right];
        }
        right--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Solution3().trap(a));
  }
}
