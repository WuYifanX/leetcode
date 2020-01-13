package leetcode416_PartitionEqualSubsetSum;

class Solution {

  // dp[n][c] 表示从[0.....n-1]能否选出容量为c的解.
  // -1 表示不能, 0 表示还没有操作, 1表示可以;
  private int[][] dp;

  public boolean canPartition(int[] nums) {
    if (nums.length == 0) return true;

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (sum % 2 != 0) return false;

    dp = new int[nums.length][sum / 2 + 1];
    return tryPartition(nums, nums.length - 1, sum / 2);
  }

  private boolean tryPartition(int[] nums, int n, int capacity) {
    if (n < 0 || capacity < 0) return false;

    if (dp[n][capacity] == 1) {
      return true;
    } else if (dp[n][capacity] == -1) {
      return false;
    }

    if (capacity == 0) return true;

    if (tryPartition(nums, n - 1, capacity) || tryPartition(nums, n - 1, capacity - nums[n])) {
      dp[n][capacity] = 1;
    } else {
      dp[n][capacity] = -1;
    }

    return dp[n][capacity] == 1;
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {1, 11, 5, 5};
    System.out.println(new Solution().canPartition(inputs));
  }
}
