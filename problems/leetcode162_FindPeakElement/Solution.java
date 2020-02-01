package leetcode162_FindPeakElement;

class Solution {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;
    if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
    return findPeakElement(nums, 0, nums.length - 1);
  }

  private int findPeakElement(int[] nums, int start, int end) {

    if (end - start <= 1) return nums[start] >= nums[end] ? start : end;

    int middle = start + (end - start) / 2;

    if (nums[middle] >= nums[middle - 1] && nums[middle] >= nums[middle + 1]) return middle;

    if (nums[middle] >= nums[middle - 1]) {
      return findPeakElement(nums, middle + 1, end);
    } else {
      return findPeakElement(nums, start, middle - 1);
    }
  }
}
