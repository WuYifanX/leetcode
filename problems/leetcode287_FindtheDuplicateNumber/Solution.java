package leetcode287_FindtheDuplicateNumber;

class Solution {
  public int findDuplicate(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return -1;

    int slow = nums[0];
    int fast = nums[0];

    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) break;
    }

    int cursor = nums[0];

    while (slow != cursor) {
      slow = nums[slow];
      cursor = nums[cursor];
    }

    return slow;
  }
}
