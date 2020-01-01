package leetcode347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import utils.Logs;

public class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {

    if (nums.length == 0) return new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    Queue<Entry<Integer, Integer>> queue =
        new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

    for (int i = 0; i < nums.length; i++) {
      countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
    }

    queue.addAll(countMap.entrySet());

    while (k > 0) {
      result.add(queue.poll().getKey());
      k--;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 1, 1, 2, 2, 3};
    Logs.print(new Solution().topKFrequent(input, 2));
  }
}
