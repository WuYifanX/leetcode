package leetcode80_RemoveDuplicatesfromSortedArrayII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private Map<Integer, Integer> countMaps = new HashMap<>();

  public int removeDuplicates2(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }

    // the slowCursor + 1 is to be replaced.
    // slowCursor - 1 is the first element
    int slowCursor = 1;
    // iterate cursor;
    int fastCursor = 2;

    while (fastCursor < nums.length) {

      if (nums[fastCursor] == nums[slowCursor] && nums[fastCursor] == nums[slowCursor - 1]) {
        fastCursor++;
      } else {

        if (nums[fastCursor] != nums[slowCursor]) {
          slowCursor++;
          nums[slowCursor] = nums[fastCursor];
          fastCursor++;

        } else if (nums[fastCursor] != nums[slowCursor - 1]) {
          slowCursor++;
          nums[slowCursor] = nums[fastCursor];
          fastCursor++;
        }
      }
    }

    return slowCursor + 1;
  }

  public static void main(String[] args) {
    int[] input = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
    System.out.println(new Solution().removeDuplicates2(input));
  }
}
