package leetcode40_CombinationSumII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();
  private Deque<Integer> stack;
  private Map<Integer, Integer> countMap;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    if (candidates.length == 0 || target <= 0) return result;

    countMap = new HashMap<>();
    for (int value : candidates) countMap.put(value, countMap.getOrDefault(value, 0) + 1);
    stack = new ArrayDeque<>();
    innerCombinationSum2(target);
    return result;
  }

  private void innerCombinationSum2(int target) {
    if (target == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }

    if (target < 0) return;

    for (Entry<Integer, Integer> entry : countMap.entrySet()) {
      // 等于0的时候需要排除.
      if (entry.getValue() == 0) continue;
      // 就是说需要排除逆序的出现, [3,2,1] , [1,3,2]这种
      if (!stack.isEmpty() && entry.getKey() < stack.peekLast()) continue;

      stack.addLast(entry.getKey());
      countMap.put(entry.getKey(), entry.getValue() - 1);

      innerCombinationSum2(target - entry.getKey());

      stack.removeLast();
      countMap.put(entry.getKey(), entry.getValue() + 1);

      if (target - entry.getKey() < 0) return;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[] {10, 1, 2, 7, 6, 1, 5};
    List<List<Integer>> lists = new Solution().combinationSum2(input, 8);
    System.out.println(lists);
  }
}
