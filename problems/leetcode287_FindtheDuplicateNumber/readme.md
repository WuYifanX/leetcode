# Leetcode

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

# Solution

1. 一般来说使用排序和hashmap来实现. 
但是如果要实现题目的要求, 可以参考这里使用链表的环的方法:
`https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/`

```java
class Solution {
  public int findDuplicate(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return -1;

    int slow = nums[0];
    int fast = nums[0];

    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) break;
    }

    int cursor = nums[0];

    while (slow != cursor) {
      slow = nums[slow];
      cursor = nums[cursor];
    }

    return slow;
  }
}

```
