# Leetcode

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

```

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

```

# Solution

1. 使用map可以避免掉重复排序关系. 比如说可以避免掉[1,1,6] 出现2次, 
但是没办法解决[1, 1, 6], [1, 6, 1]这种重复. 就是说需要排除逆序的出现, [3,2,1] , [1,3,2]这种.
通过
`if (!stack.isEmpty() && entry.getKey() < stack.peekLast()) continue;`

```java
package leetcode40_CombinationSumII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;
  private Map<Integer, Integer> countMap;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    if (candidates.length == 0 || target <= 0) return result;

    countMap = new TreeMap<>();
    for (int value : candidates) countMap.put(value, countMap.getOrDefault(value, 0) + 1);
    stack = new ArrayDeque<>();
    innerCombinationSum2(target);
    return result;
  }

  private void innerCombinationSum2(int target) {
    if (target == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    if (target < 0) return;

    for (Entry<Integer, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() == 0) continue;
      if (!stack.isEmpty() && entry.getKey() < stack.peekLast()) continue;
      stack.addLast(entry.getKey());
      countMap.put(entry.getKey(), entry.getValue() - 1);
      innerCombinationSum2(target - entry.getKey());
      stack.removeLast();
      countMap.put(entry.getKey(), entry.getValue() + 1);

      if (target - entry.getKey() < 0) return;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[] {10, 1, 2, 7, 6, 1, 5};
    List<List<Integer>> lists = new Solution().combinationSum2(input, 8);
    System.out.println(lists);
  }
}

```
