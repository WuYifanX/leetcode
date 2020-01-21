# Leetcode

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

```
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

```

# Solution

需要定义好二分的函数的定义即可.

```java
package leetcode34_FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

class Solution {
  private int[] result = new int[2];

  public int[] searchRange(int[] nums, int target) {
    Arrays.fill(result, -1);

    if (nums.length == 0) return result;


    binarySearch(nums, 0, nums.length - 1, target);
    return result;
  }

  private void binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) {
      return;
    }

    if (start == end) {
      if (nums[start] == target) {
        updateIndex(start);
      }
      return;
    }

    int middle = start + (end - start) / 2;

    if (nums[middle] > target) {
      binarySearch(nums, start, middle - 1, target);
      return;
    }

    if (nums[middle] < target) {
      binarySearch(nums, middle + 1, end, target);
      return;
    }

    if (nums[middle] == target) {
      updateIndex(middle);
      binarySearch(nums, start, middle - 1, target);
      binarySearch(nums, middle + 1, end, target);
    }
  }

  private void updateIndex(int index) {
    if (result[0] == -1) {
      result[0] = index;
      result[1] = index;
    } else {
      if (index < result[0]) {
        result[0] = index;
      }

      if (index > result[1]) {
        result[1] = index;
      }
    }
  }
}

```
