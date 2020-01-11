# Leetcode

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0

# Solution

有序, 那么二分搜索:

```java
package leetcode35_SearchInsertPosition;

class Solution {
  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) return 0;
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
    if (left >= right) {
      if (nums[left] == target || target < nums[left]) return left;
      if (target > nums[left]) return left + 1;
    }

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) return mid;
    if (target > nums[mid]) return binarySearch(nums, mid + 1, right, target);
    if (target < nums[mid]) return binarySearch(nums, left, mid - 1, target);

    return -1;
  }
}

```
