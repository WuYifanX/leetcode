package leetcode79_WordSearch;

class Solution {
  // 上 右 下 左
  private int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  private boolean[][] used;

  public boolean exist(char[][] board, String word) {
    if (word.length() == 0) return true;
    if (board.length == 0) return false;

    used = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (findStartFrom(board, i, j, word, 0)) return true;
      }
    }
    return false;
  }

  // 从这里开始遍历上右下左.
  private boolean findStartFrom(char[][] board, int x, int y, String word, int wordIndex) {
    if (wordIndex == word.length()) return true;

    if (!isValidXY(board, x, y)) return false;
    if (used[x][y]) return false;
    if (board[x][y] != word.charAt(wordIndex)) return false;

    used[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int[] direction = directions[i];
      if (findStartFrom(board, x + direction[0], y + direction[1], word, wordIndex + 1))
        return true;
    }
    used[x][y] = false;
    return false;
  }

  private boolean isValidXY(char[][] board, int x, int y) {
    return !(x >= board.length || x < 0 || y >= board[0].length || y < 0);
  }

  public static void main(String[] args) {

    char[][] board =
        new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    System.out.println(new Solution().exist(board, "ABCCED"));
  }
}
