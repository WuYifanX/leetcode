package leetcode33_SearchInRotatedSortedArray;

class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    return partialBinarySearch(nums, 0, nums.length - 1, target);
  }

  private int partialBinarySearch(int[] nums, int start, int end, int target) {
    if (start > end) return -1;
    if (start == end) return nums[start] == target ? start : -1;

    int middle = start + (end - start) / 2;
    if (nums[middle] == target) return middle;

    int partResult1;
    int partResult2;
    if (nums[start] < nums[middle]) {
      partResult1 = binarySearch(nums, start, middle - 1, target);
    } else {
      partResult1 = partialBinarySearch(nums, start, middle - 1, target);
    }

    if (nums[middle] < nums[end]) {
      partResult2 = binarySearch(nums, middle + 1, end, target);
    } else {
      partResult2 = partialBinarySearch(nums, middle + 1, end, target);
    }

    if (partResult1 != -1) {
      return partResult1;
    } else if (partResult2 != -1) {
      return partResult2;
    }

    return -1;
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    if (start == end) return nums[start] == target ? start : -1;
    if (target > nums[end] || target < nums[start]) return -1;

    int middle = start + (end - start) / 2;
    if (nums[middle] == target) return middle;

    if (nums[middle] > target) {
      return binarySearch(nums, start, middle - 1, target);
    } else {
      return binarySearch(nums, middle + 1, end, target);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {1, 3}, 0));

  }
}
