# Leetcode

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

```
Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

# Solution

1. 双端队列Deque来实现区间的O(1)的时间复杂度.
```java
package leetcode239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) return new int[] {};
    if (nums.length <= k) {
      int result = nums[0];
      for (int i = 1; i < nums.length; i++) {
        result = Math.max(result, nums[i]);
      }
      return new int[] {result};
    }

    Deque<Integer> deque = new ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];

    deque.addLast(nums[0]);
    for (int i = 1; i < k; i++) {
      updateDeque(deque, nums[i]);
    }
    result[0] = deque.peekFirst();

    for (int i = k; i < nums.length; i++) {
      if (nums[i - k] == deque.peekFirst()) {
        deque.removeFirst();
      }
      updateDeque(deque, nums[i]);
      result[i - k + 1] = deque.peekFirst();
    }

    return result;
  }

  private void updateDeque(Deque<Integer> deque, int value) {
    while (!deque.isEmpty() && deque.peekLast() < value) {
      deque.removeLast();
    }

    if (!deque.isEmpty() && deque.peekLast() >= value) {
      deque.addLast(value);
    }

    if (deque.isEmpty()) {
      deque.addLast(value);
    }
  }
}

```
