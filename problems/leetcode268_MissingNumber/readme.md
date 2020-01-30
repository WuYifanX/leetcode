# Leetcode
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

# Solution

```java
package leetcode268_MissingNumber;

class Solution {
  public int missingNumber(int[] nums) {
    if (nums.length == 0) return 0;

    for (int i = 0; i < nums.length; i++) {
      placeValueInRightPosition(nums, nums[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) return i;
    }
    return nums.length;
  }

  private void placeValueInRightPosition(int[] nums, int value) {
    if (value == nums.length || value == nums[value]) {
      return;
    }

    int temp = nums[value];
    nums[value] = value;

    placeValueInRightPosition(nums, temp);
  }
}

```

