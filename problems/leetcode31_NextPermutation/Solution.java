package leetcode31_NextPermutation;

import java.util.Arrays;
import utils.Logs;

class Solution {
  public void nextPermutation(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return;

    int swapIndex;
    for (swapIndex = nums.length - 2; swapIndex >= 0; swapIndex--) {
      if (nums[swapIndex + 1] > nums[swapIndex]) {
        break;
      }
    }

    if (swapIndex == -1) {
      Arrays.sort(nums);
      return;
    }

    int firstBigger = -1;
    for (int i = swapIndex + 1; i < nums.length; i++) {
      if (nums[swapIndex] < nums[i]) {
        if (firstBigger == -1 || nums[i] < nums[firstBigger]) firstBigger = i;
      }
    }

    int temp = nums[firstBigger];
    nums[firstBigger] = nums[swapIndex];
    nums[swapIndex] = temp;

    Arrays.sort(nums, swapIndex + 1, nums.length);
  }
}
