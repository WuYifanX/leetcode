# Leetcode

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

```
Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

```
# Solution

1. 记忆化搜索版本: Solution1
2. dp. Solution2

```java
package leetcode213_HouseRobberII;

import java.util.Arrays;

class Solution {

  private int[][] memo;

  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

    memo = new int[nums.length][nums.length];

    for (int i = 0; i < nums.length; i++) {
      Arrays.fill(memo[i], -1);
    }

    int result;

    result =
        Math.max(
            tryRob(nums, 0, nums.length - 2),
            nums[nums.length - 1] + tryRob(nums, 1, nums.length - 3));
    return result;
  }

  // try to rob the house[start, ....., n] and return max.
  // 0 2
  private int tryRob(int[] nums, int start, int n) {
    if (start > n) return 0;
    if (start == n) {
      return nums[start];
    }
    if (start + 1 == n) {
      return Math.max(nums[start], nums[n]);
    }

    if (memo[start][n] != -1) return memo[start][n];

    memo[start][n] = Math.max(tryRob(nums, start, n - 1), nums[n] + tryRob(nums, start, n - 2));
    return memo[start][n];
  }
}

```

Solution2:

```java
package leetcode213_HouseRobberII;

class Solution2 {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

    return Math.max(
        tryRob(nums, 0, nums.length - 2), nums[nums.length - 1] + tryRob(nums, 1, nums.length - 3));
  }

  // try to rob the house[start, ....., n] and return max.
  private int tryRob(int[] nums, int start, int n) {
    if (start == n) return nums[start];

    int[] dp = new int[n + 1];

    dp[start] = nums[start];
    dp[start + 1] = Math.max(nums[start], nums[start + 1]);

    for (int i = start + 2; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }

    return dp[n];
  }
}

```
