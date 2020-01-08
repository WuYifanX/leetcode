package leetcode90_Subsetsii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Map<Integer, Integer> maps = new HashMap<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {

    if (nums.length == 0) return result;

    for (int value : nums) {
      maps.put(value, maps.getOrDefault(value, 0) + 1);
    }

    result.add(new ArrayList<>());
    int index = 0;
    int resultSize;
    List<Integer> newList;
    for (Entry<Integer, Integer> entry : maps.entrySet()) {
      resultSize = result.size();
      int count = entry.getValue();
      for (int i = 0; i < resultSize; i++) {
        for (int j = 1; j <= count; j++) {
          newList = new ArrayList<>(result.get(i));
          int appendTimesLeft = j;
          while (appendTimesLeft > 0) {
            newList.add(entry.getKey());
            appendTimesLeft--;
          }

          result.add(newList);
        }
      }
    }
    return result;
  }
}
