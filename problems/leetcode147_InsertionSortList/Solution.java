package leetcode147_InsertionSortList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode result = new ListNode(0);
    ListNode current;
    ListNode next;
    ListNode prev;

    while (dummy.next != null) {
      current = dummy.next;
      next = current.next;
      dummy.next = next;

      prev = result;
      while (true) {
        if (prev.next == null) {
          prev.next = current;
          current.next = null;
          break;
        }

        if (current.val < prev.next.val) {
          current.next = prev.next;
          prev.next = current;
          break;
        } else {
          prev = prev.next;
        }
      }
    }

    return result.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {4, 3232, 121, 2, 1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().insertionSortList(head));
  }
}
