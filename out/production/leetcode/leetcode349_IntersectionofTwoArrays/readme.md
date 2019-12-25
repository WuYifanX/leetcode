# Leetcode

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.


# Solution

```java

package leetcode349_IntersectionofTwoArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import utils.Logs;

public class Solution {

  private Map<Integer, Boolean> maps;

  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1.length == 0) {
      return nums1;
    }
    if (nums2.length == 0) {
      return nums2;
    }

    List<Integer> res = new ArrayList<>();

    maps = new HashMap<>(nums1.length);
    for (int i : nums1) {
      maps.put(i, false);
    }

    for (int j : nums2) {
      if (maps.containsKey(j) && !maps.get(j)) {
        maps.put(j, true);
      }
    }

    for (Entry<Integer, Boolean> entry : maps.entrySet()) {
      if (entry.getValue()) {
        res.add(entry.getKey());
      }
    }
    return res.stream().mapToInt(i -> i).toArray();
  }


  public static void main(String[] args) {
    Logs.print(new Solution().intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
    Logs.print(new Solution().intersection(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
  }
}

```

