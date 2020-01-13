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
