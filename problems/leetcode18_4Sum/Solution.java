package leetcode18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length < 4) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);

    for (int i = 0; i <= nums.length - 4; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = i + 1; j <= nums.length - 3; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }

        twoSum(nums, j + 1, nums.length - 1, target - nums[i] - nums[j], i, j);
      }
    }
    return res;
  }

  private void twoSum(int[] nums, int leftCursor, int rightCursor, int target, int i, int j) {
    while (leftCursor < rightCursor) {
      if (nums[leftCursor] + nums[rightCursor] == target) {
        res.add(Arrays.asList(nums[i], nums[j], nums[leftCursor], nums[rightCursor]));
        leftCursor++;

        // 同理, 这里也需要跳过.
        while (leftCursor < rightCursor && nums[leftCursor] == nums[leftCursor - 1]) {
          leftCursor++;
        }
      }

      if (leftCursor < rightCursor && nums[leftCursor] + nums[rightCursor] > target) {
        rightCursor--;
      }

      if (leftCursor < rightCursor && nums[leftCursor] + nums[rightCursor] < target) {
        leftCursor++;
      }
    }
  }

  public static void main(String[] args) {

//    int[] a = new int[] {1, 0, -1, 0, -2, 2};
        int[] a = new int[] {-1,-5,-5,-3,2,5,0,4};
    new Solution().fourSum(a, -7);
  }
}

