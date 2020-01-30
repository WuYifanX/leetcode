package leetcode169_MajorityElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public int majorityElement(int[] nums) {
    if (nums.length == 1) return nums[0];

    Map<Integer, Integer> maps = new HashMap<>();

    for (int num : nums) {
      maps.put(num, maps.getOrDefault(num, 0) + 1);
    }

    Entry<Integer, Integer> maxEntry = null;
    for (Entry<Integer, Integer> entry : maps.entrySet()) {
      if (maxEntry == null) {
        maxEntry = entry;
        continue;
      }

      if (entry.getValue() > maxEntry.getValue()) maxEntry = entry;
    }

    return maxEntry.getKey();
  }
}
