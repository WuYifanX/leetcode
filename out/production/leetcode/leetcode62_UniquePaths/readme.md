# Leetcode

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.

```
Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
```


# Solution

1. 最简单的DP问题, 如果直接是二维数组的话:

```java
package leetcode62_UniquePaths;

class Solution {
  public int uniquePaths(int m, int n) {
    if (n == 0 || m == 0) return 0;

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
          continue;
        }
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    return dp[m-1][n-1];
  }
}

```

2. 当然可以使用简化方法来压缩:

只是建立2的数组, 那么也就可以通过`i % 2`方式来做.

```java

package leetcode62_UniquePaths;

class Solution {
  public int uniquePaths(int m, int n) {
    if (n == 0 || m == 0) return 0;
    int[][] dp = new int[2][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i % 2][j] = 1;
          continue;
        }
        dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
      }
    }

    return dp[(m - 1) % 2][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().uniquePaths(3, 7));
  }
}

```
