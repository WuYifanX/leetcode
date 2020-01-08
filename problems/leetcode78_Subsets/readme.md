# Leetcode

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

```
Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```


# Solution

1. 其实都没必要遍历, 只需要判断自己这一位需要不需要存在, 然后去看下一位需要不需要存在.见Solution1
2. 从头开始遍历, 每次一个数都需要用之前的结果生成一个新的子串然后丢进去.
```
[1,2,3]

[[]]

在1的时候: [[],[1]]
在2的时候: [[], [1], [2],[1,2]]
在3的时候: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

3. 还是正常的递归迭代, 只是每次都会加入result里面, 具体的可以看solution3


Solution:

```java
package leetcode78_Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) {
      return result;
    }

    stack = new ArrayDeque<>();
    subsets(nums, 0);
    return result;
  }

  private void subsets(int[] nums, int start) {
    if (start == nums.length) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int j = 0; j < 2; j++) {
      if (j % 2 == 1) stack.addLast(nums[start]);
      subsets(nums, start + 1);
      if (j % 2 == 1) stack.removeLast();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().subsets(new int[] {1, 2, 3}));
  }
}


```


Solution2

```java

package leetcode78_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) {
      return result;
    }

    result.add(new ArrayList<>());

    for (int i = 0; i < nums.length; i++) {
      int resultSize = result.size();
      for (int j = 0; j < resultSize; j++) {
        List<Integer> temp = new ArrayList<>(result.get(j));
        temp.add(nums[i]);
        result.add(temp);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().subsets(new int[] {1, 2, 3}));
  }
}

```


Solution3

```java
package leetcode78_Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution3 {

  private List<List<Integer>> result = new ArrayList<>();

  private Deque<Integer> stack;

  public List<List<Integer>> subsets(int[] nums) {

    if (nums.length == 0) return result;
    stack = new ArrayDeque<>();
    subsets(nums, 0);

    return result;
  }

  private void subsets(int[] nums, int start) {
    result.add(new ArrayList<>(stack));

    for (int i = start; i < nums.length; i++) {
      stack.addLast(nums[i]);
      subsets(nums, i + 1);
      stack.removeLast();
    }
  }
}

```
