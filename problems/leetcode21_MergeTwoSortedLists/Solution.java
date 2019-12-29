package leetcode21_MergeTwoSortedLists;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */

// test case: length == length ; > ; <; single null; both null;
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode dummy = new ListNode(0);
    ListNode l1Cursor = l1;
    ListNode l2Cursor = l2;
    ListNode resultCursor = dummy;

    while (l1Cursor != null && l2Cursor != null) {
      if (l1Cursor.val < l2Cursor.val) {
        resultCursor.next = l1Cursor;
        l1Cursor = l1Cursor.next;
        resultCursor = resultCursor.next;
        resultCursor.next = null;
      } else {
        resultCursor.next = l2Cursor;
        l2Cursor = l2Cursor.next;
        resultCursor = resultCursor.next;
        resultCursor.next = null;
      }
    }

    while (l1Cursor != null) {
      resultCursor.next = l1Cursor;
      l1Cursor = l1Cursor.next;
      resultCursor = resultCursor.next;
      resultCursor.next = null;
    }

    while (l2Cursor != null) {
      resultCursor.next = l2Cursor;
      l2Cursor = l2Cursor.next;
      resultCursor = resultCursor.next;
      resultCursor.next = null;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 4};
    int[] input2 = new int[] {1, 3, 4};
    ListNode head = Logs.createListNodes(input);
    ListNode head2 = Logs.createListNodes(input2);
    Logs.print(new Solution().mergeTwoLists(head, head2));
  }
}
