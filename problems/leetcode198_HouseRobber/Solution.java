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
