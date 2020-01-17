# Leetcode

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

```
Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

```

# Solution

```java
package leetcode119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;
import utils.Logs;

public class Solution {
  public List<Integer> getRow(int rowIndex) {
    rowIndex = rowIndex + 1;
    List<Integer> res = new ArrayList<>();
    if (rowIndex == 0) {
      res.add(1);
      return res;
    }
    int[][] resArray = new int[2][rowIndex + 1];
    int i;
    for (i = 0; i <= rowIndex; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          resArray[i % 2][j] = 1;
        } else {
          resArray[i % 2][j] = resArray[(i - 1) % 2][j - 1] + resArray[(i - 1) % 2][j];
        }
      }
    }

    for (int value : resArray[i % 2]) {
      if (value != 0) res.add(value);
    }
    return res;
  }

  public static void main(String[] args) {
    Logs.print(new Solution().getRow(4));
  }
}

```

