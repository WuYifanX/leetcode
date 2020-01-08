package leetcode78_Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution3 {

  private List<List<Integer>> result = new ArrayList<>();

  private Deque<Integer> stack;

  public List<List<Integer>> subsets(int[] nums) {

    if (nums.length == 0) return result;
    stack = new ArrayDeque<>();
    subsets(nums, 0);

    return result;
  }

  private void subsets(int[] nums, int start) {
    result.add(new ArrayList<>(stack));

    for (int i = start; i < nums.length; i++) {
      stack.addLast(nums[i]);
      subsets(nums, i + 1);
      stack.removeLast();
    }
  }
}
