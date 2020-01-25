# Leetcode

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

```
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

```

# Solution

1. 两次二分搜索: Solution1:
2. 一次二分搜索: Solution2:

```
注意到输入的 m x n 矩阵可以视为长度为 m x n的有序数组。
由于该数组的序号可以由下式方便地转化为原矩阵中的行和列

row = idx / n ， col = idx % n。

```


```java
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

```


```java


class Solution {
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

```
