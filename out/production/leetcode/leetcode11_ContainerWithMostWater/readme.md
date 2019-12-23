#Leetcode

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Input: [1,8,6,2,5,4,8,3,7]
Output: 49


# Solution
一开始两个指针一个指向开头一个指向结尾，此时容器的底是最大的，接下来随着指针向内移动，会造成容器的底变小，在这种情况下想要让容器盛水变多，就只有在容器的高上下功夫。 那我们该如何决策哪个指针移动呢？我们能够发现不管是左指针向右移动一位，还是右指针向左移动一位，容器的底都是一样的，都比原来减少了 1。这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，所以我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会。

```java
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


```
