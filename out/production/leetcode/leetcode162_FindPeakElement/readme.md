# Leetcode

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

```
Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.


```

# Solution

1. 这里可以使用二分搜索. 
因为可以根据middle的与middle+1的比较来舍弃一半的数.

我这里没必要做那么复杂, 应该直接可以用正常的二分就可以了.

```java
package leetcode162_FindPeakElement;

class Solution {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;
    if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
    return findPeakElement(nums, 0, nums.length - 1);
  }

  private int findPeakElement(int[] nums, int start, int end) {

    if (end - start <= 1) return nums[start] >= nums[end] ? start : end;

    int middle = start + (end - start) / 2;

    if (nums[middle] >= nums[middle - 1] && nums[middle] >= nums[middle + 1]) return middle;

    if (nums[middle] >= nums[middle - 1]) {
      return findPeakElement(nums, middle + 1, end);
    } else {
      return findPeakElement(nums, start, middle - 1);
    }
  }
}

```
