# Leetcode

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```


# Solution

1. 如果已经排序过了的话, 那就可以提前结束剪枝.


```java
package leetcode39_CombinationSum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {

  private Deque<Integer> stack;
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    if (target <= 0 || candidates.length == 0) return result;

    Arrays.sort(candidates);
    stack = new ArrayDeque<>();
    innerCombinationSum(candidates, 0, target);
    return result;
  }

  private void innerCombinationSum(int[] candidates, int start, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      stack.addLast(candidates[i]);
      innerCombinationSum(candidates, i, target - candidates[i]);
      stack.removeLast();
      if (target - candidates[i] < 0) return;
    }
  }
}

```
