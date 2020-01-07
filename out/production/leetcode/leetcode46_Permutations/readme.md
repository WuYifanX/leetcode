# Leetcode

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


# Solution

这题需要思考的点就是, 如何才能去知道哪些点是已经拿过的?

```java
package leetcode46_Permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) return result;
    stack = new ArrayDeque<>();

    permute(nums, new boolean[nums.length]);
    return result;
  }

  private void permute(int[] nums, boolean[] isUsed) {
    if (isAllFinish(isUsed)) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int i = 0; i < isUsed.length; i++) {
      if (isUsed[i]) continue;

      isUsed[i] = true;
      stack.addLast(nums[i]);

      permute(nums, isUsed);

      stack.removeLast();
      isUsed[i] = false;
    }
  }

  private boolean isAllFinish(boolean[] isUsed) {
    for (int i = 0; i < isUsed.length; i++) {
      if (!isUsed[i]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] {1, 2, 3}));
  }
}

```
