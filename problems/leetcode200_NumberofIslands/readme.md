# Leetcode

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

```
Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
```

# Solution

1. DFS的bloodFill: Solution1 
2. BFS的bloodFill: Solution2
3. UnionFind


```java
package leetcode200_NumberofIslands;

class Solution {
  private boolean[][] isVisited;
  private int islandsCount = 0;

  private int[][] directions = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

  public int numIslands(char[][] grid) {

    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

    isVisited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!isVisited[i][j] && grid[i][j] == '1') {
          bloodFill(grid, i, j);
          islandsCount++;
        }
      }
    }
    return islandsCount;
  }

  private void bloodFill(char[][] grid, int x, int y) {
    for (int i = 0; i < 4; i++) {
      int newX = x + directions[i][0];
      int newY = y + directions[i][1];
      if (isValid(grid, newX, newY) && !isVisited[newX][newY] && grid[newX][newY] == '1') {
        isVisited[newX][newY] = true;
        bloodFill(grid, newX, newY);
      }
    }
  }

  private boolean isValid(char[][] grid, int x, int y) {
    return !(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length);
  }
}
```


```java
package leetcode200_NumberofIslands;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
  private boolean[][] isVisited;
  private int islandsCount = 0;

  private Deque<Integer[]> deque = new ArrayDeque<>();

  private int[][] directions = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

  public int numIslands(char[][] grid) {

    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    isVisited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!isVisited[i][j] && grid[i][j] == '1') {
          isVisited[i][j] = true;
          deque.addLast(new Integer[] {i, j});
          bloodFill(grid);
          islandsCount++;
        }
      }
    }
    return islandsCount;
  }

  private void bloodFill(char[][] grid) {
    while (!deque.isEmpty()) {
      Integer[] newPosition = deque.pollLast();
      for (int i = 0; i < 4; i++) {
        int newX = newPosition[0] + directions[i][0];
        int newY = newPosition[1] + directions[i][1];
        if (isValid(grid, newX, newY) && !isVisited[newX][newY] && grid[newX][newY] == '1') {
          isVisited[newX][newY] = true;
          deque.addLast(new Integer[] {newX, newY});
        }
      }
    }
  }

  private boolean isValid(char[][] grid, int x, int y) {
    return !(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length);
  }
}


```
