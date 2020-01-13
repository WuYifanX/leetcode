package leetcode51_NQueens;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

  private List<List<String>> result;
  private boolean[] isColUsed;
  private boolean[] dia1;
  private boolean[] dia2;

  public List<List<String>> solveNQueens(int n) {

    result = new ArrayList<>();
    isColUsed = new boolean[n];
    dia1 = new boolean[(2 * n - 1)];
    dia2 = new boolean[(2 * n - 1)];

    solveQueens(n, 0, new ArrayDeque<>());
    return result;
  }

  private void solveQueens(int n, int rowIndex, Deque<Integer> answer) {
    if (rowIndex == n) {
      result.add(buildAnswer(answer, n));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!isColUsed[i] && !dia1[i + rowIndex] && !dia2[rowIndex - i + n - 1]) {
        isColUsed[i] = true;
        dia1[i + rowIndex] = true;
        dia2[rowIndex - i + n - 1] = true;
        answer.addLast(i);
        solveQueens(n, rowIndex + 1, answer);
        answer.removeLast();
        isColUsed[i] = false;
        dia1[i + rowIndex] = false;
        dia2[rowIndex - i + n - 1] = false;
      }
    }
  }

  private List<String> buildAnswer(Deque<Integer> answer, int n) {
    Deque<Integer> temp = new ArrayDeque<>(answer);
    List<String> result = new ArrayList<>();
    StringBuilder sb;
    while (!temp.isEmpty()) {
      sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (i != temp.peekLast()) {
          sb.append(".");
        } else {
          sb.append("Q");
        }
      }
      result.add(sb.toString());
      temp.removeLast();
    }

    return result;
  }
}
