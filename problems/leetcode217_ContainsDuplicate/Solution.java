package leetcode217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean containsDuplicate(int[] nums) {

    if (nums.length == 0) {
      return false;
    }

    Set<Integer> countSet = new HashSet<>();

    for (int currentValue : nums) {
      if (countSet.contains(currentValue)) {
        return true;
      } else {
        countSet.add(currentValue);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] inputs2 = new int[] {1, 2, 3, 4};
    System.out.println(new Solution().containsDuplicate(inputs2));

  }
}
