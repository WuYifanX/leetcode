package leetcode59_SpiralMatrixII;

class Solution {
  private int[][] result;
  private int index = 1;
  private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int[][] generateMatrix(int n) {
    if (n == 0) return new int[][] {};
    if (n == 1) return new int[][] {{1}};

    result = new int[n][n];
    for (int i = 0; i < (n + 1) / 2; i++) {
      result[i][i] = index;
      index++;
      goCircle(i, i);
    }

    return result;
  }

  private void goCircle(int x, int y) {
    int newX = x, newY = y;
    int length = result.length;

    for (int i = 0; i < directions.length; i++) {
      while (true) {
        newX += directions[i][0];
        newY += directions[i][1];

        if (newX >= 0 && newY >= 0 && newX < length && newY < length && result[newX][newY] == 0) {
          result[newX][newY] = index;
          index++;
        } else {
          newX -= directions[i][0];
          newY -= directions[i][1];
          break;
        }
      }
    }
  }
}
