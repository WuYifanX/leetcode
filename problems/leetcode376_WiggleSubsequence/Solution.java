package leetcode376_WiggleSubsequence;

class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 1) return nums.length;

    // 计算波峰波谷的个数.
    boolean isIncreasing = true;
    boolean init = true;
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (init) {
        if (nums[i] - nums[i - 1] < 0) {
          isIncreasing = false;
        }
        if (nums[i] != nums[i - 1]) {
          init = false;
          count++;
        }
      } else {
        if (nums[i] - nums[i - 1] > 0 && !isIncreasing) {
          isIncreasing = true;
          count++;
        }
        if (nums[i] - nums[i - 1] < 0 && isIncreasing) {
          isIncreasing = false;
          count++;
        }
      }
    }
    return count + 1;
  }
}
