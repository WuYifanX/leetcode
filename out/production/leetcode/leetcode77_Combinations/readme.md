# Leetcode

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

# Solution

1. 可以注意下这里的剪枝优化操作:

`for (int i = start; i <= n - leftCount + 1; i++) {`

```java
package leetcode77_Combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> combine(int n, int k) {
    if (k > n) return result;

    stack = new ArrayDeque<>(k);
    innerCombine(n, 1, k);
    return result;
  }

  public void innerCombine(int n, int start, int leftCount) {
    if (leftCount == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    // tips: 这里可以提前返回剪枝完成.
    // 因为 leftCount表示, 我还需要多少个元素, 假如说leftCount ==2; 那么i == n, 也就没办法找到最后一个了.
    // 所以这里可以把原始的这一句话优化下:
    //  for (int i = start; i <= n; i++) {
    for (int i = start; i <= n - leftCount + 1; i++) {
      stack.addLast(i);
      leftCount--;
      innerCombine(n, i + 1, leftCount);
      leftCount++;
      stack.removeLast();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().combine(4, 2));
  }
}


```
