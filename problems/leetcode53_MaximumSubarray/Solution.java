package leetcode53_MaximumSubarray;

public class Solution {
  public int maxSubArray(int[] nums) {

    int result = Integer.MIN_VALUE;

    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    // i, j is from index i to index j;
    int[] dp = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (i == j) {
          dp[j] = nums[i];
        } else {
          dp[j] = dp[j - 1] + nums[j];
        }
        result = Math.max(dp[j], result);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}
