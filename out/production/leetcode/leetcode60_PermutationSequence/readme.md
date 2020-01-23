# Leetcode

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

```
Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
```

# Solution



```java
package leetcode60_PermutationSequence;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  private Deque<Integer> stack = new ArrayDeque<>();
  private boolean[] used;
  private int k;
  private String result;
  private int N;

  public String getPermutation(int n, int k) {
    if (n == 0) return "";
    if (n == 1) return "1";

    N = n;
    this.k = k;
    used = new boolean[n + 1];
    dfs(n);
    return result;
  }

  private void dfs(int n) {
    if (result != null) return;
    if (n == 0) {
      k--;
      if (k == 0) {
        result = buildString();
      }
      return;
    }

    for (int i = 1; i < used.length; i++) {

      if (k > cal(N - 1)) {
        k -= cal(N - 1);
        continue;
      }

      if (used[i]) continue;
      used[i] = true;
      stack.addLast(i);
      dfs(n - 1);
      if (result != null) return;
      used[i] = false;
      stack.removeLast();
    }
  }

  private String buildString() {
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }
    return sb.toString();
  }

  private int cal(int n) {
    int result = 1;

    while (n >= 2) {
      result *= n;
      n--;
    }
    return result;
  }
}

```
