# Leetcode

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

```
Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


```

# Solution

参考这个人的答案:
https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/

总的来说, 思路很牛逼:
这道题我们拿到基本就可以确定是图的 dfs、bfs 遍历的题目了。
题目中解释说被包围的区间不会存在于边界上，所以我们会想到边界上的 OO 要特殊处理，只要把边界上的 OO 特殊处理了，那么剩下的 OO 替换成 XX 就可以了。
问题转化为，如何寻找和边界联通的 OO，我们需要考虑如下情况。

这时候的 OO 是不做替换的。因为和边界是连通的。为了记录这种状态，我们把这种情况下的 OO 换成 # 作为占位符，待搜索结束之后，遇到 OO 替换为 XX（和边界不连通的 OO）；遇到 #，替换回 $O(和边界连通的 OO)。

如何寻找和边界联通的OO? 从边界出发，对图进行 dfs 和 bfs 即可。这里简单总结下 dfs 和 dfs。

bfs 递归。可以想想二叉树中如何递归的进行层序遍历。
bfs 非递归。一般用队列存储。
dfs 递归。最常用，如二叉树的先序遍历。
dfs 非递归。一般用 stack。
那么基于上面这种想法，我们有四种方式实现。

```java
package leetcode130_SurroundedRegions;

public class Solution {
  private boolean[][] isVisited;

  private int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return;
    isVisited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
          if (!isVisited[i][j] && board[i][j] == 'O') {
            bloodFill(board, i, j);
          }
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        if (board[i][j] == '#') board[i][j] = 'O';
      }
    }
  }

  private void bloodFill(char[][] board, int x, int y) {
    isVisited[x][y] = true;
    board[x][y] = '#';

    for (int i = 0; i < 4; i++) {
      int newX = x + directions[i][0];
      int newY = y + directions[i][1];
      if (isValidPosition(board, newX, newY)) {
        if (!isVisited[newX][newY] && board[newX][newY] == 'O') {
          bloodFill(board, newX, newY);
        }
      }
    }
  }

  private boolean isValidPosition(char[][] board, int x, int y) {
    return !(x < 0 || y < 0 || x >= board.length || y >= board[0].length);
  }
}

```
