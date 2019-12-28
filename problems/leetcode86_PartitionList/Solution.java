package leetcode86_PartitionList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    ListNode prev = dummyNode;
    ListNode current = prev.next;
    ListNode greaterHead = null;
    ListNode greaterNewNode = null;
    ListNode next;
    while (current != null) {
      next = current.next;

      if (current.val < x) {
        prev = current;
        current = next;
      } else {
        if (greaterHead == null) {
          greaterHead = current;
          greaterNewNode = current;
        }

        // add greater node into other linkedlist
        greaterNewNode.next = current;
        greaterNewNode = greaterNewNode.next;
        current.next = null;

        // update prev next pointer to delete's next node;
        prev.next = next;

        // update current node;
        current = next;
      }
    }

    if (greaterHead != null) {
      prev.next = greaterHead;
    }

    return dummyNode.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 4, 3, 2, 5, 2};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution().partition(head, 3));
  }
}
