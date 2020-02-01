package leetcode378_KthSmallestElementinaSortedMatrix;

class Solution2 {
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;

    int start = matrix[0][0];
    int end = matrix[n - 1][n - 1];
    int middleValue;
    int position;
    // when start == end then exist, start must be the result;
    while (start < end) {
      middleValue = start + (end - start) / 2;
      position = findNotBiggerThanMid(matrix, middleValue);

      if (position < k) {
        start = middleValue + 1;
      } else {
        // assert (position <= k);
        end = middleValue;
      }
    }

    return start;
  }

  private int findNotBiggerThanMid(int[][] matrix, int targetValue) {
    int n = matrix.length;
    int i = n - 1;
    int j = 0;
    int result = 0;

    while (i >= 0 && j <= n - 1) {
      if (matrix[i][j] <= targetValue) {
        result += i + 1;
        j++;
      } else {
        i--;
      }
    }

    return result;
  }
}
