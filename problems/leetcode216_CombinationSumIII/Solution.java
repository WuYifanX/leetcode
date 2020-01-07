package leetcode216_CombinationSumIII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> combinationSum3(int k, int n) {
    if (k == 0 || n < 1) return result;

    stack = new ArrayDeque<>();
    innerCombinationSum3(k, n, 1);
    return result;
  }

  private void innerCombinationSum3(int k, int n, int start) {
    if (k == 0 && n == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    if (k == 0 || n < 0) {
      return;
    }

    for (int i = start; i < 10; i++) {

      stack.addLast(i);
      innerCombinationSum3(k - 1, n - i, i + 1);
      stack.removeLast();
      if (n - i < 0) return;
    }
  }
}
