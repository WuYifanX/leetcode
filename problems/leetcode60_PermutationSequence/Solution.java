package leetcode60_PermutationSequence;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  private Deque<Integer> stack = new ArrayDeque<>();
  private boolean[] used;
  private int k;
  private String result;
  private int N;

  public String getPermutation(int n, int k) {
    if (n == 0) return "";
    if (n == 1) return "1";

    N = n;
    this.k = k;
    used = new boolean[n + 1];
    dfs(n);
    return result;
  }

  private void dfs(int n) {
    if (result != null) return;
    if (n == 0) {
      k--;
      if (k == 0) {
        result = buildString();
      }
      return;
    }

    for (int i = 1; i < used.length; i++) {

      if (k > cal(N - 1)) {
        k -= cal(N - 1);
        continue;
      }

      if (used[i]) continue;
      used[i] = true;
      stack.addLast(i);
      dfs(n - 1);
      if (result != null) return;
      used[i] = false;
      stack.removeLast();
    }
  }

  private String buildString() {
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }
    return sb.toString();
  }

  private int cal(int n) {
    int result = 1;

    while (n >= 2) {
      result *= n;
      n--;
    }
    return result;
  }
}
