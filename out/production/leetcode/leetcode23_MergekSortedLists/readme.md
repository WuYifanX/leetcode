# Leetcode


Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


# Solution


1. 暴力做法: 把所有的数据放在数组里面, 然后排序, 然后生成一个链表
2. 优先队列逐步比较来生成
3. 逐一两两合并链表, 将合并 k 个链表的问题转化成合并 2 个链表 k-1 次。
4. 分治, 其实是mergesort的方法, 可以把3中的k-1减少次数.


参考 https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode/

```java
package leetcode23_MergekSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import utils.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;

    Queue<ListNode> priorityQueue =
        new PriorityQueue<>(
            lists.length,
            Comparator.comparingInt(node -> node.val));

    for (ListNode node : lists) {
      if (node != null) priorityQueue.add(node);
    }

    ListNode dummyNode = new ListNode(0);
    ListNode currentNode = dummyNode;
    ListNode minNode;

    while (!priorityQueue.isEmpty()) {
      minNode = priorityQueue.poll();
      currentNode.next = minNode;
      currentNode = currentNode.next;

      if (currentNode.next != null) {
        priorityQueue.add(currentNode.next);
      }
      currentNode.next = null;
    }

    return dummyNode.next;
  }
}


```
