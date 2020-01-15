package leetcode377_CombinationSumIV;

import java.util.Arrays;

class Solution {
  private int[] memo;

  public int combinationSum4(int[] nums, int target) {
    if (target == 0) return 0;
    memo = new int[target + 1];
    Arrays.fill(memo, -1);

    return innerCombinationSum4(nums, target);
  }

  // return combination of target.
  private int innerCombinationSum4(int[] nums, int target) {
    if (target == 0) {
      return 1;
    }
    if (target < 0) {
      return 0;
    }

    if (memo[target] != -1) return memo[target];

    int result = 0;
    int sub;

    for (int i = 0; i < nums.length; i++) {
      sub = innerCombinationSum4(nums, target - nums[i]);
      if (sub == 0) continue;
      result += innerCombinationSum4(nums, target - nums[i]);
    }

    memo[target] = result;
    return memo[target];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum4(new int[] {1, 2, 3}, 4));
  }
}
