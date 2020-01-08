package leetcode90_Subsetsii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution2 {

  private List<List<Integer>> result = new ArrayList<>();

  private Deque<Integer> stack;

  public List<List<Integer>> subsetsWithDup(int[] nums) {

    if (nums.length == 0) return result;
    stack = new ArrayDeque<>();
    Arrays.sort(nums);
    subsetsWithDup(nums, 0);

    return result;
  }

  private void subsetsWithDup(int[] nums, int start) {
    result.add(new ArrayList<>(stack));

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      stack.addLast(nums[i]);
      subsetsWithDup(nums, i + 1);
      stack.removeLast();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().subsetsWithDup(new int[] {1, 1, 3}));
  }
}
