package leetcode47_permutations_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution2 {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;
  private Map<Integer, Integer> countMap;

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return result;

    stack = new ArrayDeque<>();
    buildCountMap(nums);
    innerPermuteUnique();
    return result;
  }

  private void buildCountMap(int[] nums) {
    countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
  }

  private void innerPermuteUnique() {
    if (isAllUsed()) {
      result.add(new ArrayList<>(stack));
      return;
    }

    for (Entry<Integer, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() == 0) continue;

      countMap.put(entry.getKey(), entry.getValue() - 1);
      stack.addLast(entry.getKey());
      innerPermuteUnique();
      countMap.put(entry.getKey(), entry.getValue() + 1);
      stack.removeLast();
    }
  }

  private boolean isAllUsed() {
    for (Integer count : countMap.values()) {
      if (count != 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().permuteUnique(new int[] {1,1,3}));
  }
}
