# Leetcode

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

```
Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

# Solution

1. 每次去查询, 只能前面的1去调用后面的1, 不能后面的1调用前面的1. Solution1
能够避免[1,1,2], [1,1,2]出现重复, 因为再最外层map的key=1的过程只会执行一次.
但是, 没办法避免出现[1,1,2], [1,2,1], 但是在全排列的场景完全符合. 


```java
package leetcode47_permutations_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return result;

    stack = new ArrayDeque<>();
    permuteUnique(nums, new boolean[nums.length]);
    return result;
  }

  private void permuteUnique(int[] nums, boolean[] isUsed) {
    if (isAllUsed(isUsed)) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int i = 0; i < isUsed.length; i++) {
      if (isUsed[i]) continue;
      // 如果后面的相同的数调用前面相同的数, 那就continue;
      if (!isFirstInUnused(nums, isUsed, i)) continue;

      isUsed[i] = true;
      stack.addLast(nums[i]);
      permuteUnique(nums, isUsed);
      isUsed[i] = false;
      stack.removeLast();
    }
  }

  private boolean isFirstInUnused(int[] nums, boolean[] isUsed, int i) {
    int earliestIndex = i;

    for (int j = isUsed.length - 1; j >= 0; j--) {
      if (isUsed[j]) continue;

      if (nums[i] == nums[j]) earliestIndex = j;
    }
    return earliestIndex == i;
  }

  private boolean isAllUsed(boolean[] isUsed) {
    for (int i = 0; i < isUsed.length; i++) {
      if (!isUsed[i]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().permuteUnique(new int[] {3, 3, 3}));
  }
}


```

2. 使用Map来存储, 更加简单. 更容易解决这个重复的问题
```java
package leetcode47_permutations_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution2 {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;
  private Map<Integer, Integer> countMap;

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return result;

    stack = new ArrayDeque<>();
    buildCountMap(nums);
    innerPermuteUnique();
    return result;
  }

  private void buildCountMap(int[] nums) {
    countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
  }

  private void innerPermuteUnique() {
    if (isAllUsed()) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (Entry<Integer, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() == 0) continue;

      countMap.put(entry.getKey(), entry.getValue() - 1);
      stack.addLast(entry.getKey());
      innerPermuteUnique();
      countMap.put(entry.getKey(), entry.getValue() + 1);
      stack.removeLast();
    }
  }

  private boolean isAllUsed() {
    for (Integer count : countMap.values()) {
      if (count != 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().permuteUnique(new int[] {1,1,3}));
  }
}


```

