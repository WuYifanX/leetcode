# Leetcode

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?


# Thoughts:


# Solution1:
三路快速排序

```
public void sortColors(int[] nums) {

    if (nums.length <= 1) {
      return;
    }

    // [0, ..., lessThanPointer] is value = 0
    int lessThanPointer = -1;

    // [lessThanPointer +1, ... , cursor -1] is value = 1;
    int cursor = 0;
    // [greatThanPointer, ...., nums.length -1] is value = 2;
    int greatThanPointer = nums.length;

    while (cursor < greatThanPointer) {

      if (nums[cursor] == 0) {
        lessThanPointer++;
        swap(nums, lessThanPointer, cursor);
        cursor++;
      } else if (nums[cursor] == 1) {
        cursor++;
      } else {
        greatThanPointer--;
        swap(nums, cursor, greatThanPointer);
      }
    }
  }

```
