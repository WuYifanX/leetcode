# Leetcode

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.

# Thoughts:

需要考虑:

1. 如何定义删掉? 是赋值成为 null, 还是说放在末尾.
2. 能否改变原来数组的顺序

# Solution1:

双指针, fastCursor, slowCursor, 分别代表: 遍历指针和可以覆写的位置
需要去比较fastCursor和slowCursor -1 的单元是否相同.

第一版的代码考虑的情况太多, 简化后为:

```
public int removeDuplicates2(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }

    // the slowCursor + 1 is to be replaced.
    // slowCursor - 1 is the first element
    int slowCursor = 1;
    // iterate cursor;
    int fastCursor = 2;

    while (fastCursor < nums.length) {

      if (nums[fastCursor] == nums[slowCursor] && nums[fastCursor] == nums[slowCursor - 1]) {
        fastCursor++;
      } else {
        slowCursor++;
        nums[slowCursor] = nums[fastCursor];
        fastCursor++;
      }
    }

    return slowCursor + 1;
  }

```
