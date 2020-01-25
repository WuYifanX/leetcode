package leetcode73_SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

class Solution {

  public void setZeroes(int[][] matrix) {

    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          xSet.add(i);
          ySet.add(j);
          break;
        }
      }
    }

    for (Integer x : xSet) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[x][i] = 0;
      }
    }

    for (Integer y : ySet) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][y] = 0;
      }
    }
  }
}
