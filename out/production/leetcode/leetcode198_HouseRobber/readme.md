# Leetcode

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


```
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

```
# Solution

1. dp[i] 考虑去偷[i, ....,n-1]的房子的东西
2. 状态转移方程是 dp[i] = MAX{v(0) + dp[2], v(1) + dp[3], ...., v(n-3) + dp[i-1],v(n-2), v(n-1) } 最后两项只有v, 没有dp是因为dp为0;

```java
package leetcode198_HouseRobber;

public class Solution {
  // consider to stolen from [i,....,n-1]
  private int[] dp;

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    dp = new int[nums.length];

    dp[nums.length - 1] = nums[nums.length - 1];
    dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);

    for (int i = nums.length - 3; i >= 0; i--) {
      dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
    }
    return dp[0];
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {0, 1};
    System.out.println(new Solution().rob(inputs));
  }
}

```
