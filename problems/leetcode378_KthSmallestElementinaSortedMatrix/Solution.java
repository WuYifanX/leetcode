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
