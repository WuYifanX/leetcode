package leetcode2_AddTwoNumbers;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode l1Cursor = l1;
    ListNode l2Cursor = l2;
    int combinedValue = 0;

    ListNode dummy = new ListNode(0);
    dummy.next = null;

    ListNode resultCursor = dummy;
    while (l1Cursor != null && l2Cursor != null) {
      combinedValue = l1Cursor.val + l2Cursor.val + combinedValue / 10;

      resultCursor.next = new ListNode(combinedValue % 10);
      resultCursor = resultCursor.next;
      l1Cursor = l1Cursor.next;
      l2Cursor = l2Cursor.next;
    }

    while (l1Cursor != null) {
      combinedValue = l1Cursor.val + combinedValue / 10;
      resultCursor.next = new ListNode(combinedValue % 10);
      resultCursor = resultCursor.next;
      l1Cursor = l1Cursor.next;
    }

    while (l2Cursor != null) {
      combinedValue = l2Cursor.val + combinedValue / 10;

      resultCursor.next = new ListNode(combinedValue % 10);
      resultCursor = resultCursor.next;
      l2Cursor = l2Cursor.next;
    }

    if (combinedValue > 9) {
      resultCursor.next = new ListNode(combinedValue / 10);
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {5, 9};
    int[] input2 = new int[] {5};
    ListNode head = Logs.createListNodes(input);
    ListNode head2 = Logs.createListNodes(input2);
    Logs.print(new Solution().addTwoNumbers(head, head2));
  }
}
