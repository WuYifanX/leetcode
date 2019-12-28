package leetcode92_ReverseLinkedListII;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n || head == null) {
      return head;
    }
    // because we might need to reverse the first node,
    // so in order to unify the operation, we need to create dummy node.
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    ListNode prev = dummyNode;
    for (int i = 0; i < m - 1; i++) {
      prev = prev.next;
    }

    ListNode current = prev.next;
    ListNode next = current.next;
    for (int i = 0; i < n - m; i++) {
      ListNode nextNext = next.next;
      next.next = current;
      current = next;
      next = nextNext;
    }

    prev.next.next = next;
    prev.next = current;

    return dummyNode.next;
  }

  // 1->2->3->4->5->null
  // 1->4->3->2->5->null
  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution().reverseBetween(head, 1, 5));
  }
}
