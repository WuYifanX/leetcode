package leetcode39_CombinationSum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {

  private Deque<Integer> stack;
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    if (target <= 0 || candidates.length == 0) return result;

    Arrays.sort(candidates);
    stack = new ArrayDeque<>();
    innerCombinationSum(candidates, 0, target);
    return result;
  }

  private void innerCombinationSum(int[] candidates, int start, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      stack.addLast(candidates[i]);
      innerCombinationSum(candidates, i, target - candidates[i]);
      stack.removeLast();
      if (target - candidates[i] < 0) return;
    }
  }
}
