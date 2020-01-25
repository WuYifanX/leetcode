package leetcode74_Searcha2DMatrix;

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;
    if (matrix[0].length == 0) return false;

    int lowerRowIndex = 0;
    int upperRowIndex = matrix.length - 1;
    int middleIndex;
    int currentValue;
    while (lowerRowIndex <= upperRowIndex) {
      middleIndex = lowerRowIndex + (upperRowIndex - lowerRowIndex) / 2;
      currentValue = matrix[middleIndex][0];
      if (currentValue == target) return true;

      if (currentValue > target) {
        upperRowIndex = middleIndex - 1;
      } else {
        lowerRowIndex = middleIndex + 1;
      }
    }

    if (upperRowIndex < 0) return false;

    int lowerColIndex = 0;
    int upperColIndex = matrix[upperRowIndex].length - 1;
    int middleColIndex;

    while (lowerColIndex <= upperColIndex) {
      middleColIndex = lowerColIndex + (upperColIndex - lowerColIndex) / 2;
      currentValue = matrix[upperRowIndex][middleColIndex];
      if (currentValue == target) return true;

      if (currentValue > target) {
        upperColIndex = middleColIndex - 1;
      } else {
        lowerColIndex = middleColIndex + 1;
      }
    }
    return false;
  }
}
