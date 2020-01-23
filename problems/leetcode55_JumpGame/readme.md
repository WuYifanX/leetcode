# Leetcode

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

```
Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


```

# Solution

1. 回溯做法 Solution1
2. 贪心做法 


```java
package leetcode55_JumpGame;

class Solution {

  private boolean[] isVisited;
  private boolean result;

  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;

    isVisited = new boolean[nums.length];
    dfs(nums, 0);
    return result;
  }

  private void dfs(int[] nums, int index) {
    if (result) return;

    if (index == nums.length - 1) {
      result = true;
      return;
    }

    isVisited[index] = true;

    for (int i = 1; i <= nums[index]; i++) {
      if (index + i < nums.length && !isVisited[index + i]) {
        dfs(nums, index + i);
      }

      if (index - i >= 0 && !isVisited[index - i]) {
        dfs(nums, index - i);
      }
    }
  }
}

```

贪心这里是重点: i <= maxLength
```java
class Solution {
  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;

    int maxLength = 0;
    for (int i = 0; i <= maxLength; i++) {
      maxLength = Math.max(maxLength, i + nums[i]);
      if (maxLength >= nums.length - 1) return true;
    }

    return false;
  }
}
// [2,3,1,1,4]
// [3,2,1,0,4]


```
