package leetcode377_CombinationSumIV;

class Solution2 {
  private int[] dp;

  public int combinationSum4(int[] nums, int target) {
    if (target == 0) return 0;
    dp = new int[target + 1];
    dp[0] = 1;

    //
    // dp[i] = dp[i - nums[0]] + dp[i - nums[1]].....;

    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i - nums[j] >= 0) dp[i] += dp[i - nums[j]];
      }
    }

    return dp[target];
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().combinationSum4(new int[] {1, 2, 3}, 4));
  }
}
