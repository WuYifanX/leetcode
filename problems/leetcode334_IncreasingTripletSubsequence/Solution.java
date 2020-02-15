package leetcode334_IncreasingTripletSubsequence;

import java.util.Arrays;

class Solution {
  public boolean increasingTriplet(int[] nums) {
    if (nums.length <= 2) return false;

    int[] increasingArrays = new int[3];
    Arrays.fill(increasingArrays, Integer.MAX_VALUE);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < increasingArrays[0]) {


      }

      if (increasingArrays[2] != Integer.MAX_VALUE) return true;
    }

    return false;
  }
}
