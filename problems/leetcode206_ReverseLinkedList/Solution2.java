package leetcode206_ReverseLinkedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
// 与Solution的区别在于有prev, current, next指针. 操作的是current指针.
class Solution2 {
  public ListNode reverseList(ListNode head) {

    if (head == null) {
      return null;
    }
    ListNode prev = null;
    ListNode current = head;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  //  1->2->3->4->5->null
  //      5->4->3->2->1->null
  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution2().reverseList(head));
  }
}
