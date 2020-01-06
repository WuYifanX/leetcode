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
