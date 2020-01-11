package leetcode35_SearchInsertPosition;

class Solution {
  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) return 0;
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
    if (left >= right) {
      if (nums[left] == target || target < nums[left]) return left;
      if (target > nums[left]) return left + 1;
    }

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) return mid;
    if (target > nums[mid]) return binarySearch(nums, mid + 1, right, target);
    if (target < nums[mid]) return binarySearch(nums, left, mid - 1, target);

    return -1;
  }
}
