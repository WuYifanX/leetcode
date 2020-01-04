package leetcode198_HouseRobber;

import java.util.Arrays;

public class Solution2 {
  // consider to stolen from [i,....,n-1]
  private int[] memo;

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return tryRob(nums, 0);
  }

  public int tryRob(int[] nums, int i) {
    if (i >= nums.length) return 0;

    if (memo[i] != -1) return memo[i];

    memo[i] = Math.max(nums[i] + tryRob(nums, i + 2), tryRob(nums, i+1));
    return memo[i];
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {0, 1};
    System.out.println(new Solution2().rob(inputs));
  }
}
