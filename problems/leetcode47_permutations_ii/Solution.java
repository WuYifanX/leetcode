package leetcode47_permutations_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return result;

    stack = new ArrayDeque<>();
    permuteUnique(nums, new boolean[nums.length]);
    return result;
  }

  private void permuteUnique(int[] nums, boolean[] isUsed) {
    if (isAllUsed(isUsed)) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int i = 0; i < isUsed.length; i++) {
      if (isUsed[i]) continue;
      // 如果后面的相同的数调用前面相同的数, 那就continue;
      if (!isFirstInUnused(nums, isUsed, i)) continue;

      isUsed[i] = true;
      stack.addLast(nums[i]);
      permuteUnique(nums, isUsed);
      isUsed[i] = false;
      stack.removeLast();
    }
  }

  private boolean isFirstInUnused(int[] nums, boolean[] isUsed, int i) {
    int earliestIndex = i;

    for (int j = isUsed.length - 1; j >= 0; j--) {
      if (isUsed[j]) continue;

      if (nums[i] == nums[j]) earliestIndex = j;
    }
    return earliestIndex == i;
  }

  private boolean isAllUsed(boolean[] isUsed) {
    for (int i = 0; i < isUsed.length; i++) {
      if (!isUsed[i]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().permuteUnique(new int[] {3, 3, 3}));
  }
}
