package leetcode300_LongestIncreasingSubsequence;

import java.util.Arrays;

class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length <= 1) return nums.length;

    // LIS[i] is between [0,...i];
    int[] LIS = new int[nums.length];
    Arrays.fill(LIS, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          LIS[i] = Math.max(LIS[i], LIS[j] + 1);
        }
      }
    }

    int result = 1;
    for (int value : LIS) {
      result = Math.max(result, value);
    }

    return result;
  }
}
