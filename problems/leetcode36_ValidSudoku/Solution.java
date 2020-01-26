package leetcode36_ValidSudoku;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    boolean[][] column = new boolean[9][9];
    boolean[][] row = new boolean[9][9];
    boolean[][][] subbox = new boolean[3][3][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') continue;

        int number = board[i][j] - '1';

        if (column[j][number] || row[i][number] || subbox[i / 3][j / 3][number]) return false;
        column[j][number] = true;
        row[i][number] = true;
        subbox[i / 3][j / 3][number] = true;
      }
    }

    return true;
  }
}
