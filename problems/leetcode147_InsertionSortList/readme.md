# Leetcode

Sort a linked list using insertion sort.

A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5


# Solution

```java

package leetcode147_InsertionSortList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode result = new ListNode(0);
    ListNode current;
    ListNode next;
    ListNode prev;

    while (dummy.next != null) {
      current = dummy.next;
      next = current.next;
      dummy.next = next;

      prev = result;
      while (true) {
        if (prev.next == null) {
          prev.next = current;
          current.next = null;
          break;
        }

        if (current.val < prev.next.val) {
          current.next = prev.next;
          prev.next = current;
          break;
        } else {
          prev = prev.next;
        }
      }
    }

    return result.next;
  }

  public static void main(String[] args) {
    int[] input = new int[] {4, 3232, 121, 2, 1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().insertionSortList(head));
  }
}

```
