# Leetcode

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

```
Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.



# Solution

1. PriorityQueue可以解决这个问题.
2. 二分搜索也可以解决.

```java
package leetcode378_KthSmallestElementinaSortedMatrix;

import java.util.PriorityQueue;

class Solution {

  private class Node implements Comparable {
    private int value;
    private int x;
    private int y;

    private Node(int value, int x, int y) {
      this.value = value;
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Object o) {
      return this.value - ((Node) o).value;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int length = matrix.length;
    PriorityQueue<Node> pq = new PriorityQueue<>(length);

    for (int i = 0; i < matrix[0].length; i++) {
      pq.add(new Node(matrix[0][i], 0, i));
    }

    Node smallestForCurrent;
    int current;
    for (int i = 0; i < k - 1; i++) {
      smallestForCurrent = pq.poll();
      if (smallestForCurrent.x < length - 1) {
        current = matrix[smallestForCurrent.x + 1][smallestForCurrent.y];
        pq.add(new Node(current, smallestForCurrent.x + 1, smallestForCurrent.y));
      }
    }

    return pq.poll().value;
  }
}

```

```java
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

```
