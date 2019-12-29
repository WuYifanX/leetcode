package Leetcode237_DeleteNodeInALinkedList;

import utils.ListNode;

class Solution {
  public void deleteNode(ListNode node) {

    ListNode next = node.next;
    node.val = next.val;

    node.next = next.next;
    next.next = null;
  }
}
