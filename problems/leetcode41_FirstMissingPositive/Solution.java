package leetcode41_FirstMissingPositive;

class Solution {
  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) return 1;

    for (int i = 0; i < nums.length; i++) {
      int currentValue = nums[i];
      nums[i] = 0;
      placeValueInRightPlace(nums, currentValue);
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) return i + 1;
    }

    return nums.length + 1;
  }

  private void placeValueInRightPlace(int[] nums, int currentValue) {
    if (currentValue > nums.length || currentValue <= 0) return;
    if (currentValue == nums[currentValue - 1]) return;
    int temp = nums[currentValue - 1];
    nums[currentValue - 1] = currentValue;
    placeValueInRightPlace(nums, temp);
  }
}
