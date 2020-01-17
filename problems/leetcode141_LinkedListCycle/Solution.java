package leetcode141_LinkedListCycle;

import utils.ListNode;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode fast = head;
    ListNode slow = head;

    int flag = 0;
    while (fast.next != null) {
      fast = fast.next;
      flag++;
      if (flag % 2 == 0) slow = slow.next;
      if (slow == fast) break;
    }

    return slow == fast;
  }
}
