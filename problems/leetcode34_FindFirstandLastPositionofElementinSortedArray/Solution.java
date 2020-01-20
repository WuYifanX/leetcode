//package leetcode34_FindFirstandLastPositionofElementinSortedArray;
//
//import java.util.Arrays;
//
//class Solution {
//  private int[] result = new int[2];
//
//  public int[] searchRange(int[] nums, int target) {
//    if (nums.length == 0) return result;
//
//    Arrays.fill(result, -1);
//
//    binarySearch(nums, 0, nums.length - 1, target);
//    return result;
//  }
//
//  private void binarySearch(int[] nums, int start, int end, int target) {
//    if (start > end) {}
//
//    int middle = start + (end - start) / 2;
//
//    if (nums[middle] > target) {
//      binarySearch(nums, start, middle - 1, target);
//      return;
//    }
//
//    if (nums[middle] < target) {
//      binarySearch(nums, middle + 1, end, target);
//      return;
//    }
//
//
//  }
//}
