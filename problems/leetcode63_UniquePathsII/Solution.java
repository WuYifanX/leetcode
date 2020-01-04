package leetcode63_UniquePathsII;

public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null) return 0;

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    if (obstacleGrid[m - 1][n - 1] == 1) return 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else {
          if (i == 0 && j == 0) {
            obstacleGrid[0][0] = 1;
            continue;
          }
          if (i == 0) {
            obstacleGrid[i][j] = obstacleGrid[i][j - 1];
          } else if (j == 0) {
            obstacleGrid[i][j] = obstacleGrid[i - 1][j];
          } else {
            obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
          }
        }
      }
    }
    return obstacleGrid[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{0, 0}};
    System.out.println(new Solution().uniquePathsWithObstacles(input));
  }
}
