# Leetcode

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

```
Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

# Solution

1.因为要实现min的时间复杂度是O(1). 所以需要有记录. 
有两个方法:
1. 使用多一个栈来保存min的数据. 
2. 如果选择不多用一个栈,那么可以考虑把minValue也继续保存在这个栈中. 
可以参考这里



https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/

```java
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

```
