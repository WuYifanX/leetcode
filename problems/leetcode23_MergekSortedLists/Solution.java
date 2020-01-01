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
