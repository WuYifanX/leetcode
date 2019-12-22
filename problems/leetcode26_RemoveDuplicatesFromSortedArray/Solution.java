package leetcode26_RemoveDuplicatesFromSortedArray;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }

    int slowCursor = 0;
    int fastCursor = 1;

    while (fastCursor < nums.length) {
      if (nums[fastCursor] == nums[slowCursor]) {
        fastCursor++;
      } else {
        slowCursor++;
        nums[slowCursor] = nums[fastCursor];
        fastCursor++;
      }
    }

    return slowCursor + 1;
  }

  public static void main(String[] args) {
    int[] input = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(new Solution().removeDuplicates(input));
  }
}
