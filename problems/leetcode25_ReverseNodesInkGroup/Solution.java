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
    //    Logs.print(new DPSolution().reverseKGroup(head, 2));
    Logs.print(new Solution().reverseKGroup(head, 3));
  }
}
