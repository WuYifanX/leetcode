package leetcode234_PalindromeLinkedList;

import utils.ListNode;
import utils.Logs;

class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode fastCursor = head.next;
    ListNode slowCursor = head;
    boolean isListOddCount = false;
    while (fastCursor.next != null) {
      fastCursor = fastCursor.next;
      if (fastCursor.next == null) {
        isListOddCount = true;
        break;
      }

      fastCursor = fastCursor.next;
      slowCursor = slowCursor.next;
    }

    fastCursor = slowCursor.next;
    if (isListOddCount) fastCursor = fastCursor.next;

    reverseListFromStartNodeToEndNode(head, slowCursor);



    while (fastCursor != null && slowCursor != null) {
      if (fastCursor.val != slowCursor.val) return false;
      fastCursor = fastCursor.next;
      slowCursor = slowCursor.next;
    }

    return fastCursor == null && slowCursor == null;
  }

  public void reverseListFromStartNodeToEndNode(ListNode startNode, ListNode endNode) {

    ListNode current = startNode;
    ListNode next = current.next;
    ListNode nextNext = next.next;
    current.next = null;
    while (current != endNode) {
      next.next = current;
      current = next;
      next = nextNext;
      nextNext = nextNext.next;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 0, 1};
    ListNode head = Logs.createListNodes(input);
    System.out.println(new Solution().isPalindrome(head));
  }
}
