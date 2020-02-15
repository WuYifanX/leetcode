package leetcode189_RotateArray;

class Solution2 {
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (nums.length == 0 || k == 0) return;

    reverseArray(nums, 0, nums.length - 1);
    reverseArray(nums, 0, k - 1);
    reverseArray(nums, k, nums.length - 1);
  }

  private void reverseArray(int[] nums, int start, int end) {
    int temp;
    while (start < end) {
      temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
