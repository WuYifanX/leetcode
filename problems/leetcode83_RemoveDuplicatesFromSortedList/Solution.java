package leetcode83_RemoveDuplicatesFromSortedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode current = head;
    ListNode next = current.next;
    while (next != null) {

      if (current.val == next.val) {
        next = next.next;
        current.next.next = null;
        current.next = next;
      } else {
        current = next;
        next = current.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 1, 2, 3, 3};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().deleteDuplicates(head));
  }
}
