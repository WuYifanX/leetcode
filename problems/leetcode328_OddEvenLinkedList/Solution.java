package leetcode328_OddEvenLinkedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int count = 1;

    ListNode prev = dummy;
    ListNode current = prev.next;
    ListNode next;
    ListNode evenListHead = null;
    ListNode evenListCurrent = null;

    while (current != null) {
      next = current.next;
      if (count % 2 == 0) {
        if (evenListHead == null) {
          evenListHead = current;
          evenListCurrent = current;
        } else {
          evenListCurrent.next = current;
          evenListCurrent = evenListCurrent.next;
        }

        current.next = null;
        prev.next = next;
        current = next;
      }else {
        prev = current;
        current = next;
      }

      count++;
    }

    if (evenListHead != null) {
      prev.next = evenListHead;
    }
    return dummy.next;
  }

  //  1->3->5->2->4->NULL
  public static void main(String[] args) {
//    int[] input = new int[] {1, 2, 3, 4, 5};
//    ListNode head = Logs.createListNodes(input);
//    Logs.print(head);
//    Logs.print(new Solution().oddEvenList(head));

    System.out.println();
    int[] input2 = new int[] {2, 1, 3, 5, 6, 4, 7};
    ListNode head2 = Logs.createListNodes(input2);
    Logs.print(head2);
    Logs.print(new Solution().oddEvenList(head2));
  }
}
