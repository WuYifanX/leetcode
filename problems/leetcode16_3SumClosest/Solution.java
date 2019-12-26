package leetcode16_3SumClosest;

import java.util.Arrays;

public class Solution {

  private int minClosetSum;

  public int threeSumClosest(int[] nums, int target) {

    int fixedIndex = 0;
    Arrays.sort(nums);
    minClosetSum = target - nums[0] - nums[1] - nums[2];
    for (; fixedIndex <= nums.length - 3; fixedIndex++) {
      while (fixedIndex > 0
          && fixedIndex <= nums.length - 3
          && nums[fixedIndex] == nums[fixedIndex - 1]) {
        fixedIndex++;
      }

      findTwoSumClosest(nums, fixedIndex + 1, nums.length - 1, target - nums[fixedIndex]);
    }
    return target - minClosetSum;
  }

  private void findTwoSumClosest(int[] nums, int start, int end, int target) {

    int leftCursor = start;
    int rightCursor = end;

    while (leftCursor < rightCursor) {

      if (Math.abs(target - nums[leftCursor] - nums[rightCursor]) < Math.abs(minClosetSum)) {
        minClosetSum = target - nums[leftCursor] - nums[rightCursor];
      }

      if (target - nums[leftCursor] - nums[rightCursor] >= 0) {
        leftCursor++;
      } else {
        rightCursor--;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[] {-1, 2, 1, -4};

    System.out.println(new Solution().threeSumClosest(a, 1));
  }
}
