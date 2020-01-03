# Leetcode
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

```
Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

```
# Solution

1. 最简单的思路是2维数组, 来做循环. 但是这样有几个问题, 需要做3个循环过程, 具体可以看Solution1:
2. 简化下Solution1, 使用dummyNode来解决这个问题, 只需要循环1次; 可以见Solution2
3. 空间最简的话, 就是使用原地来实现. 使用题目中给的数组来实现.

```java
package leetcode64_MinimumPathSum;

public class Solution {
  public int minPathSum(int[][] grid) {

    // definition
    // dp[i][j] means the mini path sum of point (i, j);

    // init the matrix.
    int[][] dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];

    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = grid[i][0] + dp[i -1][0];
    }

    for (int i = 1; i < grid[0].length; i++) {
      dp[0][i] = grid[0][i] + dp[0][i -1];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }

    return dp[grid.length - 1][grid[0].length - 1];
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(new Solution().minPathSum(input));
  }
}

```

Solution2
```java
package leetcode64_MinimumPathSum;

import java.util.Arrays;

public class Solution2 {
  public int minPathSum(int[][] grid) {
    int m = grid.length + 1;
    int n = grid[0].length + 1;
    // definition
    // dp[i][j] means the mini path sum of point (i, j);

    // init the matrix.
    int[][] dp = new int[m][n];

    // filled with max value;
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    dp[1][1] = grid[0][0];

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (i == 1 && j == 1) continue;
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
      }
    }

    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(new Solution2().minPathSum(input));
  }
}
```

Solution3
```java
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

```
