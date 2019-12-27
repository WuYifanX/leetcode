# Leetcode
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false


# Solution

1. 需要注意的是, 如果t的取值很变态, 可能会造成int的溢出的问题,所以需要使用Long.

```java

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

```
