package leetcode279_PerfectSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private List<Integer> squares;
  private int[] dq;

  public int numSquares(int n) {
    if (n == 1) return 1;

    squares = new ArrayList<>();
    dq = new int[n + 1];
    Arrays.fill(dq, Integer.MAX_VALUE);

    int i = 0;
    int square;
    while (true) {
      square = (int) Math.pow(i, 2);
      i++;
      if (square <= n) {
        squares.add(square);
      } else {
        break;
      }
    }
    return calSquares(n);
  }

  private int calSquares(int n) {
    dq[0] = 0;
    dq[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      for (int j = 1; j < squares.size() && i - squares.get(j) >= 0; j++) {
        dq[i] = Math.min(dq[i], 1 + dq[i - squares.get(j)]);
      }
    }
    return dq[n];
  }

  public static void main(String[] args) {

    System.out.println(new Solution().numSquares(4));
  }
}
