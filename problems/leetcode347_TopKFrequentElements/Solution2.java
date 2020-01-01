package leetcode347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import utils.Logs;

public class Solution2 {
  public List<Integer> topKFrequent(int[] nums, int k) {

    if (nums.length == 0) return new ArrayList<>();
    LinkedList<Integer> result = new LinkedList<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    Queue<Entry<Integer, Integer>> queue =
        new PriorityQueue<>(k, Comparator.comparingInt(Entry::getValue));

    for (int i = 0; i < nums.length; i++) {
      countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
    }

    Entry<Integer, Integer> minEntry;
    int queueCount = 0;
    for (Entry<Integer, Integer> currentEntry : countMap.entrySet()) {
      if (queueCount < k) {
        queue.add(currentEntry);
        queueCount++;
      } else {
        minEntry = queue.peek();
        if (currentEntry.getValue() > minEntry.getValue()) {
          queue.poll();
          queue.add(currentEntry);
        }
      }
    }

    while (k > 0) {
      result.addFirst(queue.poll().getKey());
      k--;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 1, 1, 2, 2, 3};
    Logs.print(new Solution2().topKFrequent(input, 2));
  }
}
