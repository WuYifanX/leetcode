package leetcode74_Searcha2DMatrix;

class Solution2 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;

    int n = matrix[0].length;
    if (n == 0) return false;

    int lowerRowIndex = 0;

    int upperRowIndex = m * n - 1;
    int middleIndex;
    int currentValue;
    while (lowerRowIndex <= upperRowIndex) {
      middleIndex = lowerRowIndex + (upperRowIndex - lowerRowIndex) / 2;
      currentValue = matrix[middleIndex / n][middleIndex % n];
      if (currentValue == target) return true;

      if (currentValue > target) {
        upperRowIndex = middleIndex - 1;
      } else {
        lowerRowIndex = middleIndex + 1;
      }
    }

    return false;
  }
}
