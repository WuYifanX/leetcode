package leetcode53_MaximumSubarray;

public class Solution3 {
  public int maxSubArray(int[] nums) {

    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    // dp[i] 表示前i个的结尾的最大子序列合
    int dp = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp = Math.max(dp + nums[i], nums[i]);
      result = Math.max(result, dp);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution3().maxSubArray(new int[] {-2, -1}));
  }
}
