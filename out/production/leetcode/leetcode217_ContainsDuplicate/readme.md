# Leetcode

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true

Example 2:

Input: [1,2,3,4]
Output: false

Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true


# Solution

```java

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

```
