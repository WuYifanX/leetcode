package leetcode78_Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) {
      return result;
    }

    stack = new ArrayDeque<>();
    subsets(nums, 0);
    return result;
  }

  private void subsets(int[] nums, int start) {
    if (start == nums.length) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int j = 0; j < 2; j++) {
      if (j % 2 == 1) stack.addLast(nums[start]);
      subsets(nums, start + 1);
      if (j % 2 == 1) stack.removeLast();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().subsets(new int[] {1, 2, 3}));
  }
}
