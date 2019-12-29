package leetcode148_SortList;

import utils.ListNode;
import utils.Logs;

class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int listSize = getSize(head);
    int iterateSize = 2;

    while (iterateSize <= listSize * 2) {
      ListNode prev = dummy;
      ListNode current = prev.next;
      while (current != null) {
        current = mergeTwoLinkList(current, iterateSize);
        prev.next = current;
        int count = 0;
        while (current != null && count < iterateSize) {
          prev = prev.next;
          current = current.next;
          count++;
        }
      }
      iterateSize *= 2;
    }

    return dummy.next;
  }

  private ListNode mergeTwoLinkList(ListNode head, int iterateSize) {
    ListNode l1 = head;
    int l1Left = iterateSize / 2;
    int l2Left = iterateSize / 2;

    ListNode l2 = l1;
    for (int i = 0; i < iterateSize / 2; i++) {
      // if l2 is null, which means this head is already sorted.
      if (l2 == null) return head;
      l2 = l2.next;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = null;
    ListNode current = dummy;

    while (l1Left > 0 && l1 != null && l2Left > 0 && l2 != null) {
      if (l1.val < l2.val) {
        current.next = l1;
        l1 = l1.next;
        current = current.next;
        current.next = null;
        l1Left--;
      } else {
        current.next = l2;
        l2 = l2.next;
        current = current.next;
        current.next = null;
        l2Left--;
      }
    }

    while (l1Left > 0 && l1 != null) {
      current.next = l1;
      l1 = l1.next;
      current = current.next;
      current.next = null;
      l1Left--;
    }

    while (l2Left > 0 && l2 != null) {
      current.next = l2;
      l2 = l2.next;
      current = current.next;
      current.next = null;
      l2Left--;
    }
    current.next = l2;
    return dummy.next;
  }

  private int getSize(ListNode head) {
    int result = 0;
    while (head != null) {
      result += 1;
      head = head.next;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] input = new int[] {-1, 5, 3, 4, 0};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().sortList(head));
  }
}
