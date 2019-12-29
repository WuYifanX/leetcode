# Leetcode

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

# Solution

有一些非常的边界条件需要注意
比如说[1,1]


```java

package leetcode82_RemoveDuplicatesfromSortedListII;

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

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    ListNode current = prev.next;
    ListNode next = current.next;
    while (current!= null && current.next != null) {
      if (next != null && current.val == next.val) {
        next = next.next;
      } else {
        if (current.val == current.next.val) {
          prev.next = next;
          current = next;
        } else {
          prev = current;
          current = current.next;
        }
        if (current != null) {
          next = current.next;
        }
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 1};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().deleteDuplicates(head));
  }
}

```
