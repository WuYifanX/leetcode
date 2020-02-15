# Leetcode

Given an array, rotate the array to the right by k steps, where k is non-negative.

```
Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

```

# Solution

先把array reverse一次, 然后再把前面的k-1位reverse, 后面的部分也reverse.
```java
package leetcode189_RotateArray;

class Solution2 {
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (nums.length == 0 || k == 0) return;

    reverseArray(nums, 0, nums.length - 1);
    reverseArray(nums, 0, k - 1);
    reverseArray(nums, k, nums.length - 1);
  }

  private void reverseArray(int[] nums, int start, int end) {
    int temp;
    while (start < end) {
      temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}

```
