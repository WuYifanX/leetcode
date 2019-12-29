package leetcode24_SwapNodesinPairs;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode swapPairs(ListNode head) {

    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;

    while (prev.next != null && prev.next.next != null) {
      // move to next step;
      ListNode current = prev.next;
      ListNode next = current.next;
      ListNode nextNext = next.next;

      // do swap
      next.next = current;
      current.next = nextNext;
      prev.next = next;

      // update the prev node;
      prev = current;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    //    int[] input = new int[] {1, 2, 3, 4};
    int[] input = new int[] {1};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().swapPairs(head));
  }
}
