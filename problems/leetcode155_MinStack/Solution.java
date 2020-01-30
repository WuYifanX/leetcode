package leetcode155_MinStack;

import java.util.Arrays;

class MinStack {

  private int[] data;
  private int minValue = Integer.MAX_VALUE;
  private int lastElementIndex = -1;

  /** initialize your data structure here. */
  public MinStack() {
    data = new int[10];
  }

  public void push(int x) {
    if (lastElementIndex + 2 >= data.length) {
      resize();
    }

    if (x <= minValue) {
      lastElementIndex++;
      data[lastElementIndex] = minValue;
      minValue = x;
    }

    lastElementIndex++;
    data[lastElementIndex] = x;
  }

  public void pop() {
    if (lastElementIndex == -1) return;

    int retValue = data[lastElementIndex];

    if (retValue == minValue) {
      lastElementIndex--;
      minValue = data[lastElementIndex];
    }
    lastElementIndex--;
    return;
  }

  public int top() {
    if (lastElementIndex == -1) return 0;
    return data[lastElementIndex];
  }

  public int getMin() {
    return minValue;
  }

  private void resize() {
    data = Arrays.copyOf(data, data.length * 2);
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
