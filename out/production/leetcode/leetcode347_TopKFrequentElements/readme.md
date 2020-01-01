# Leetcode

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

# Solution

1. 对于堆的话, 可以使用最大堆. 有点浪费资源.
2. 如果使用最小堆的话, 那么就可以最大效率的利用空间. 但是逻辑会比较绕
首先什么时候加入堆. 而且最小堆的话, 最顶端的是最小数, 所以还有用头插法每次插入结果的链表(list没有头插的方法).

```java
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

```
