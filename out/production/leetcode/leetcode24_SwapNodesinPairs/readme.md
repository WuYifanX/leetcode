# Leetcode

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.


# Solution

1. 在做之前, 应该想考虑好边界的条件, 比如说这是一个奇数的链条.
2. 链表的题目, 可以考虑先调整指针(move to next step), 再去操作(do swap). 这样可以减少代码.


```java

package leetcode24_SwapNodesinPairs;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode swapPairs(ListNode head) {

    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;

    while (prev.next != null && prev.next.next != null) {
      // move to next step;
      ListNode current = prev.next;
      ListNode next = current.next;
      ListNode nextNext = next.next;

      // do swap
      next.next = current;
      current.next = nextNext;
      prev.next = next;

      // update the prev node;
      prev = current;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    //    int[] input = new int[] {1, 2, 3, 4};
    int[] input = new int[] {1};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().swapPairs(head));
  }
}

```

