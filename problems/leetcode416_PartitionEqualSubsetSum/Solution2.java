package leetcode416_PartitionEqualSubsetSum;

public class Solution2 {
  public boolean canPartition(int[] nums) {
    if (nums.length == 0) return true;

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (sum % 2 == 1) return false;

    return tryPartition(nums, nums.length, sum / 2);
  }

  private boolean tryPartition(int[] nums, int n, int capacity) {
    boolean[][] dp = new boolean[n][capacity + 1];

    for (int j = 0; j < capacity + 1; j++) {
      dp[0][j] = nums[0] == j;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < capacity + 1; j++) {
        if (j >= nums[i]) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n - 1][capacity];
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().canPartition(new int[] {1, 5, 11, 5}));
  }
}
