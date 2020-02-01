package leetcode240_Searcha2DMatrixII;

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;

    int i = matrix.length - 1;
    int j = 0;
    int current;
    while (i >= 0 && j <= matrix[0].length - 1) {
      current = matrix[i][j];
      if (current == target) return true;
      if (current > target) {
        i--;
      } else {
        j++;
      }
    }

    return false;
  }
}
