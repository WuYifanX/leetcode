package leetcode64_MinimumPathSum;

public class Solution3 {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    // definition
    // dp[i][j] means the mini path sum of point (i, j);


    for (int i = 0; i < m; i++) {
      for (int j = 0; j <n; j++) {
        if(i == 0 && j == 0) continue;

        if(i == 0){
          grid[i][j] = grid[i][j -1] + grid[i][j];
        }else if(j == 0){
          grid[i][j] = grid[i-1][j] + grid[i][j];
        }else {
          grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
        }
      }
    }

    return grid[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(new Solution3().minPathSum(input));
  }
}
