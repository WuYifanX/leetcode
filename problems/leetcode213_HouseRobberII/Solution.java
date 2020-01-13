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
