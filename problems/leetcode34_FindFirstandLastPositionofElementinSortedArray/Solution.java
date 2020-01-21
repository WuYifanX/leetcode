package leetcode34_FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

class Solution {
  private int[] result = new int[2];

  public int[] searchRange(int[] nums, int target) {
    Arrays.fill(result, -1);

    if (nums.length == 0) return result;


    binarySearch(nums, 0, nums.length - 1, target);
    return result;
  }

  private void binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) {
      return;
    }

    if (start == end) {
      if (nums[start] == target) {
        updateIndex(start);
      }
      return;
    }

    int middle = start + (end - start) / 2;

    if (nums[middle] > target) {
      binarySearch(nums, start, middle - 1, target);
      return;
    }

    if (nums[middle] < target) {
      binarySearch(nums, middle + 1, end, target);
      return;
    }

    if (nums[middle] == target) {
      updateIndex(middle);
      binarySearch(nums, start, middle - 1, target);
      binarySearch(nums, middle + 1, end, target);
    }
  }

  private void updateIndex(int index) {
    if (result[0] == -1) {
      result[0] = index;
      result[1] = index;
    } else {
      if (index < result[0]) {
        result[0] = index;
      }

      if (index > result[1]) {
        result[1] = index;
      }
    }
  }
}
