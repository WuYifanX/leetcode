package leetcode219_ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (maps.containsKey(nums[i])) {
        if (i - maps.get(nums[i]) <= k) {
          return true;
        }
      }
      maps.put(nums[i], i);
    }
    return false;
  }
}
