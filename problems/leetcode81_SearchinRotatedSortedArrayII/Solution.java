package leetcode81_SearchinRotatedSortedArrayII;

class Solution {
  public boolean search(int[] nums, int target) {
    if (nums.length == 0) return false;
    if (nums.length == 1) return nums[0] == target;

    return partialBinarySearch(nums, 0, nums.length - 1, target);
  }

  // 3, 1 1
  private boolean partialBinarySearch(int[] nums, int left, int right, int target) {
    if (left > right) {
      return false;
    }

    int middle = left + (right - left) / 2;
    if (nums[middle] == target) return true;

    if (isRangeSorted(nums, middle, right)) {
      if (nums[middle] < target && target <= nums[right]) {
        return binarySearch(nums, middle + 1, right, target);
      } else {
        return partialBinarySearch(nums, left, middle - 1, target);
      }
    }

    if (isRangeSorted(nums, left, middle)) {
      if (nums[middle] > target && target >= nums[left]) {
        return binarySearch(nums, left, middle - 1, target);
      } else {
        return partialBinarySearch(nums, middle + 1, right, target);
      }
    }
    return false;
  }

  private boolean isRangeSorted(int[] nums, int left, int right) {
    int current = left;
    while (current < right && nums[current] == nums[right]) {
      current++;
    }

    return current == right || (nums[left] <= nums[current] && nums[current] <= nums[right]);
  }

  private boolean binarySearch(int[] nums, int left, int right, int target) {
    if (left > right) {
      return false;
    }

    int middle = left + (right - left) / 2;
    if (nums[middle] == target) return true;

    if (nums[middle] < target) {
      return binarySearch(nums, middle + 1, right, target);
    }

    if (nums[middle] > target) {
      return binarySearch(nums, left, middle - 1, target);
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {2, 2, 2, 0, 2, 2}, 0));
  }
}
