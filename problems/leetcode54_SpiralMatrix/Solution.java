package leetcode54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {

  private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private List<Integer> result = new ArrayList<>();
  private boolean[][] used;

  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return result;

    int maxXIndex = matrix.length - 1;
    int maxYIndex = matrix[0].length - 1;
    used = new boolean[maxXIndex + 1][maxYIndex + 1];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (!used[i][j]) visitRect(i, i, maxXIndex, maxYIndex, matrix);
      }
    }

    return result;
  }

  private void visitRect(int x, int y, int maxXIndex, int maxYIndex, int[][] matrix) {
    int newX = x, newY = y;
    used[newX][newY] = true;
    result.add(matrix[newX][newY]);

    for (int i = 0; i < directions.length; i++) {
      while (true) {
        newX += directions[i][0];
        newY += directions[i][1];

        if (newX > maxXIndex || newY > maxYIndex || newX < 0 || newY < 0 || used[newX][newY]) {
          newX -= directions[i][0];
          newY -= directions[i][1];
          break;
        }

        used[newX][newY] = true;
        result.add(matrix[newX][newY]);
      }
    }
  }
}
