# Leetcode

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

# Solution

```java

package leetcode83_RemoveDuplicatesFromSortedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode current = head;
    ListNode next = current.next;
    while (next != null) {

      if (current.val == next.val) {
        next = next.next;
        current.next.next = null;
        current.next = next;
      } else {
        current = next;
        next = current.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 1, 2, 3, 3};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().deleteDuplicates(head));
  }
}

```
