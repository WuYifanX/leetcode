package leetcode77_Combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> combine(int n, int k) {
    if (k > n) return result;

    stack = new ArrayDeque<>(k);
    innerCombine(n, 1, k);
    return result;
  }

  public void innerCombine(int n, int start, int leftCount) {
    if (leftCount == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int i = start; i <= n; i++) {
      stack.addLast(i);
      leftCount--;
      innerCombine(n, i + 1, leftCount);
      leftCount++;
      stack.removeLast();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().combine(4, 2));
  }
}
