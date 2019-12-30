package leetcode19_RemoveNthNodeFromEndOfList;

import utils.ListNode;
import utils.Logs;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;

    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    ListNode slowPrevCursor = dummyNode;
    ListNode fastCursor = dummyNode;

    for (int i = 0; i < n; i++) {
      if (fastCursor != null) {
        fastCursor = fastCursor.next;
      } else {
        return head;
      }
    }

    while (fastCursor.next != null) {
      fastCursor = fastCursor.next;
      slowPrevCursor = slowPrevCursor.next;
    }

    ListNode deleteNode = slowPrevCursor.next;
    slowPrevCursor.next = deleteNode.next;
    deleteNode.next = null;
    return dummyNode.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().removeNthFromEnd(head, 2));
  }
}
