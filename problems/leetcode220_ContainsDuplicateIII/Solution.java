package leetcode220_ContainsDuplicateIII;

import java.util.TreeSet;

public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length <= 1 || k < 0 || t < 0) {
      return false;
    }

    TreeSet<Long> treeSet = new TreeSet<>();

    int leftCursor = 0;
    int rightCursor = 0;

    long currentValue;
    long floorValue, ceilingValue;
    while (rightCursor < nums.length) {
      // if leftCursor is too small,  delete element in treeset and leftCursor++;
      if (rightCursor - leftCursor > k) {
        long deletedValue = nums[leftCursor];
        treeSet.remove(deletedValue);
        leftCursor++;
      }
      // use new value to find target in treeset, if true, return, if false, rightCursor++;
      currentValue = nums[rightCursor];
      // assure t >=0; but t can be out of int range. so it should use long.
      floorValue = currentValue - t;
      ceilingValue = currentValue + t;

      if (treeSet.ceiling(floorValue) != null && treeSet.ceiling(floorValue) <= ceilingValue) {
        return true;
      }

      treeSet.add(currentValue);
      rightCursor++;
    }

    return false;
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {0, 2147483647};

    System.out.println(new Solution().containsNearbyAlmostDuplicate(inputs, 1, 2147483647));

  }
}
