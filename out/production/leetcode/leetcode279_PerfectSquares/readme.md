# Leetcode

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


# Solution

```
这道题如果知道数学定理之后，相当于告诉你：

任何正整数都可以拆分成不超过4个数的平方和 ---> 答案只可能是1,2,3,4

如果一个数最少可以拆成4个数的平方和，则这个数还满足 n = (4^a)*(8b+7)
---> 因此可以先看这个数是否满足上述公式，如果不满足，答案就是1,2,3了

如果这个数本来就是某个数的平方，那么答案就是1，否则答案就只剩2,3了

如果答案是2，即n=a^2+b^2，那么我们可以枚举a，来验证，如果验证通过则答案是2
只能是3
```

DP:


```
定义:

squares表示所有的完全平方数的array.
dq[i] 表示i的最小的完全平方数的数量.

动态方程:
dq[i] = Math.min(dq[i], 1 + dq[i - squares.get(j)]);

```

```java
package leetcode279_PerfectSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private List<Integer> squares;
  private int[] dq;

  public int numSquares(int n) {
    if (n == 1) return 1;

    squares = new ArrayList<>();
    dq = new int[n + 1];
    Arrays.fill(dq, Integer.MAX_VALUE);

    int i = 0;
    int square;
    while (true) {
      square = (int) Math.pow(i, 2);
      i++;
      if (square <= n) {
        squares.add(square);
      } else {
        break;
      }
    }
    return calSquares(n);
  }

  private int calSquares(int n) {
    dq[0] = 0;
    dq[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      for (int j = 1; j < squares.size() && i - squares.get(j) >= 0; j++) {
        dq[i] = Math.min(dq[i], 1 + dq[i - squares.get(j)]);
      }
    }
    return dq[n];
  }

  public static void main(String[] args) {

    System.out.println(new Solution().numSquares(4));
  }
}

```
