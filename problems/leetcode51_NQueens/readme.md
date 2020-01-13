# Leetcode

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

```

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
```


# Solution

1. 难点在于如何建模这个模型, 然后如何快速的算出这个n皇后有没有冲突的办法
这里比较巧妙的是
col[n]表示列的占用;
dia1[2n -1], dia2[2n -1] 表示不同对角线的占用情况.


```java
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

```
