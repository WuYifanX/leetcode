package leetcode206_ReverseLinkedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode reverseList(ListNode head) {

    if (head == null) {
      return head;
    }

    ListNode current = head;
    ListNode next = current.next;
    current.next = null;

    ListNode nextNext;
    while (next != null) {
      nextNext = next.next;
      next.next = current;

      current = next;
      next = nextNext;
    }

    return current;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution().reverseList(head));
  }
}
