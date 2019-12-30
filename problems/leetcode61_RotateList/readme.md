# Leetcode

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL


# Solution

```java

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

```
