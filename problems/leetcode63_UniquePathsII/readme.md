# Leetcode

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

```

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

```

# Solution

最节约空间的肯定是原地利用原来的矩阵来实现.
```java
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

```
