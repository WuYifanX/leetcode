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
