# Leetcode

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.


# Solution

1. 各种边界和换节点的过程需要想清楚.
2. 需要重做, 基本上就是编程能力的锻炼.

```java

package leetcode25_ReverseNodesInkGroup;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  private ListNode dummy = new ListNode(0);

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1 || head == null) {
      return head;
    }

    dummy.next = head;
    ListNode prev = dummy;
    while (isEnoughNodeToSwap(prev.next, k)) {
      // swap
      prev.next = reverseKGroupForOnce(prev.next, k - 1);

      // move prev to right place;
      for (int i = 0; i < k; i++) {
        prev = prev.next;
      }
    }

    return dummy.next;
  }

  private ListNode reverseKGroupForOnce(ListNode head, int swapTimes) {
    ListNode current = null;
    ListNode next = head;
    ListNode nextNext = head.next;
    while (swapTimes > 0) {
      // update cursor
      current = next;
      next = nextNext;
      nextNext = next.next;

      // swap
      next.next = current;

      swapTimes--;
    }

    head.next = nextNext;
    return next;
  }

  private boolean isEnoughNodeToSwap(ListNode current, int swapTimes) {
    ListNode cursor = current;

    while (swapTimes - 1 > 0 && cursor != null) {
      cursor = cursor.next;
      swapTimes--;
    }

    return swapTimes == 1 && cursor != null;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    //    Logs.print(new Solution().reverseKGroup(head, 2));
    Logs.print(new Solution().reverseKGroup(head, 3));
  }
}

```
