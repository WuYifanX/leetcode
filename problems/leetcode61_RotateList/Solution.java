package leetcode61_RotateList;

import utils.ListNode;
import utils.Logs;

public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null) {
      return head;
    }

    // calculate the length of list.
    int size = 0;
    ListNode current = head;
    while (current != null) {
      current = current.next;
      size++;
    }

    if (k % size == 0) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    current = dummy;
    ListNode prev = dummy;

    for (int i = 0; i < k % size; i++) {
      current = current.next;
    }

    while (current.next != null) {
      current = current.next;
      prev = prev.next;
    }

    current.next = dummy.next;
    dummy.next = prev.next;
    prev.next = null;

    return dummy.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().rotateRight(head, 2));
  }
}
