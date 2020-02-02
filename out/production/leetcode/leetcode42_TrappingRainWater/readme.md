# Leetcode

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

```
Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

https://leetcode-cn.com/problems/trapping-rain-water/

# Solution

1. dp来记录i的往左边和右边走的最大的值, 然后来计算i这个点的能够容纳的面积. 见Solution2.
2. 其实发现, 我们只关心left和right的其中的小值. 通过这个可以使用left 和right 两个指针来解决这个问题. Solution3.

```java
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

```

```java
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

```
