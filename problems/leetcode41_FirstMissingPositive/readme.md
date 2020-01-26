# Leetcode

Given an unsorted integer array, find the smallest missing positive integer.

```
Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.

```
# Solution

1. 因为不能用额外的数组, 所以这里使用原来的数组来记录这个数字有没有出现.

```java
package leetcode41_FirstMissingPositive;

class Solution {
  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) return 1;

    for (int i = 0; i < nums.length; i++) {
      int currentValue = nums[i];
      nums[i] = 0;
      placeValueInRightPlace(nums, currentValue);
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) return i + 1;
    }

    return nums.length + 1;
  }

  private void placeValueInRightPlace(int[] nums, int currentValue) {
    if (currentValue > nums.length || currentValue <= 0) return;
    if (currentValue == nums[currentValue - 1]) return;
    int temp = nums[currentValue - 1];
    nums[currentValue - 1] = currentValue;
    placeValueInRightPlace(nums, temp);
  }
}

```
