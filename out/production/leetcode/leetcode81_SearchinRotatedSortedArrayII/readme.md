# Leetcode

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?


# Solution

1. 思路还是不变的, 想办法把数据分为有序的和无序的.
有序的来二分, 无序的再递归做这个事情.
但是问题在于说, 这个题目是有重复的, 那么就比较难判断是不是已经有序.
需要你做额外的判断, 是不是已经有序.有一些比较边缘的case {2,2,2,2,0,2}; 

```java

package leetcode81_SearchinRotatedSortedArrayII;

class Solution {
  public boolean search(int[] nums, int target) {
    if (nums.length == 0) return false;
    if (nums.length == 1) return nums[0] == target;

    return partialBinarySearch(nums, 0, nums.length - 1, target);
  }

  // 3, 1 1
  private boolean partialBinarySearch(int[] nums, int left, int right, int target) {
    if (left > right) {
      return false;
    }

    int middle = left + (right - left) / 2;
    if (nums[middle] == target) return true;

    if (isRangeSorted(nums, middle, right)) {
      if (nums[middle] < target && target <= nums[right]) {
        return binarySearch(nums, middle + 1, right, target);
      } else {
        return partialBinarySearch(nums, left, middle - 1, target);
      }
    }

    if (isRangeSorted(nums, left, middle)) {
      if (nums[middle] > target && target >= nums[left]) {
        return binarySearch(nums, left, middle - 1, target);
      } else {
        return partialBinarySearch(nums, middle + 1, right, target);
      }
    }
    return false;
  }

  private boolean isRangeSorted(int[] nums, int left, int right) {
    int current = left;
    while (current < right && nums[current] == nums[right]) {
      current++;
    }

    return current == right || (nums[left] <= nums[current] && nums[current] <= nums[right]);
  }

  private boolean binarySearch(int[] nums, int left, int right, int target) {
    if (left > right) {
      return false;
    }

    int middle = left + (right - left) / 2;
    if (nums[middle] == target) return true;

    if (nums[middle] < target) {
      return binarySearch(nums, middle + 1, right, target);
    }

    if (nums[middle] > target) {
      return binarySearch(nums, left, middle - 1, target);
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {2, 2, 2, 0, 2, 2}, 0));
  }
}

```
