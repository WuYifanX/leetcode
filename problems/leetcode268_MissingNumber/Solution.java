package leetcode268_MissingNumber;

class Solution {
  public int missingNumber(int[] nums) {
    if (nums.length == 0) return 0;

    for (int i = 0; i < nums.length; i++) {
      placeValueInRightPosition(nums, nums[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) return i;
    }
    return nums.length;
  }

  private void placeValueInRightPosition(int[] nums, int value) {
    if (value == nums.length || value == nums[value]) {
      return;
    }

    int temp = nums[value];
    nums[value] = value;

    placeValueInRightPosition(nums, temp);
  }
}
