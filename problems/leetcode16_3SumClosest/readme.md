# Leetcode

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


# Solution

1. 对于sum的系列问题, 如果使用双指针, 一定要想明白的是, 在什么场景下, 我需要去左边移, 什么情况下, 我需要去右移指针. 
想明白了这个问题, 基本上就解决了.

```java

package leetcode16_3SumClosest;

import java.util.Arrays;

public class Solution {

  private int minClosetSum;

  public int threeSumClosest(int[] nums, int target) {

    int fixedIndex = 0;
    Arrays.sort(nums);
    minClosetSum = target - nums[0] - nums[1] - nums[2];
    for (; fixedIndex <= nums.length - 3; fixedIndex++) {
      while (fixedIndex > 0
          && fixedIndex <= nums.length - 3
          && nums[fixedIndex] == nums[fixedIndex - 1]) {
        fixedIndex++;
      }

      findTwoSumClosest(nums, fixedIndex + 1, nums.length - 1, target - nums[fixedIndex]);
    }
    return target - minClosetSum;
  }

  private void findTwoSumClosest(int[] nums, int start, int end, int target) {

    int leftCursor = start;
    int rightCursor = end;

    while (leftCursor < rightCursor) {

      if (Math.abs(target - nums[leftCursor] - nums[rightCursor]) < Math.abs(minClosetSum)) {
        minClosetSum = target - nums[leftCursor] - nums[rightCursor];
      }

      if (target - nums[leftCursor] - nums[rightCursor] >= 0) {
        leftCursor++;
      } else {
        rightCursor--;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[] {-1, 2, 1, -4};

    System.out.println(new Solution().threeSumClosest(a, 1));
  }
}


```
