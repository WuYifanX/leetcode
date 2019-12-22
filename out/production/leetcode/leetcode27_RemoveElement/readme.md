# Leetcode

Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

# Thoughts:

需要考虑:

1. 如何定义删掉? 是赋值成为 null, 还是说放在末尾.
2. 能否改变原来数组的顺序

# Solution1:

在所有 java 提交中击败了 100.00%的用户.

思路: 双指针一头一尾, 尾部指针指向非 val 的元素, 然后头指针如果碰到了 val, 交换.

```pgsql
public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }

    int leftCursor = 0;
    int rightCursor = nums.length - 1;

    // [0, rightCursor] is the return array.
    while (leftCursor < rightCursor) {

      if (nums[rightCursor] == val) {
        rightCursor--;
      } else {
        if (nums[leftCursor] == val) {
          nums[leftCursor] = nums[rightCursor];
          rightCursor--;
        }
        leftCursor++;
      }
    }

    // when leftCursor == rightCursor
    if (nums[leftCursor] == val) {
      rightCursor--;
    }

    return rightCursor + 1;
  }
```
