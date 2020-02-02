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
