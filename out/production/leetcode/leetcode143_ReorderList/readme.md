# Leetcode

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


# Solution

1.快慢指针找到中点
2.拆成两个链表 
3.遍历两个链表，后面的塞到前面的“缝隙里”. 边界条件是当链条是奇数的情况下.

细节很重要, 一个细节失误, 可能就不太容易debugger.

```java
package leetcode143_ReorderList;

import utils.ListNode;
import utils.Logs;

class Solution {
  public void reorderList(ListNode head) {

    if (head == null || head.next == null) return;

    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;
    ListNode slowCursor = dummyNode;
    ListNode fastCursor = dummyNode;

    // find the middle point slowCursor;
    int moveSteps = 0;
    while (fastCursor.next != null) {
      if (moveSteps % 2 == 0) slowCursor = slowCursor.next;
      fastCursor = fastCursor.next;
      moveSteps++;
    }

    // split the list into two parts.
    ListNode middleToEndDummyNode = new ListNode(0);
    middleToEndDummyNode.next = slowCursor.next;
    slowCursor.next = null;

    reverseList(middleToEndDummyNode);

    // insert the element in reversed list into original list.
    ListNode insertCursor = dummyNode.next;
    ListNode fetchedNode;
    while (insertCursor.next != null) {
      // fetch a node from middle list;
      fetchedNode = middleToEndDummyNode.next;
      middleToEndDummyNode.next = middleToEndDummyNode.next.next;

      // insert into dummy node;
      fetchedNode.next = insertCursor.next;
      insertCursor.next = fetchedNode;

      // update insertCursor position
      insertCursor = insertCursor.next.next;
    }

    insertCursor.next = middleToEndDummyNode.next;
    middleToEndDummyNode.next = null;
  }

  private void reverseList(ListNode dummyNode) {
    if (dummyNode.next == null || dummyNode.next.next == null) {
      return;
    }

    // reverse the new list.
    ListNode prev = dummyNode;
    ListNode current = dummyNode.next;
    ListNode next;

    while (current != null) {
      // next需要在破坏current的时候才保存下一个
      next = current.next;
      current.next = prev;

      prev = current;
      current = next;
    }

    dummyNode.next.next = null;
    dummyNode.next = prev;
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(inputs);
    new Solution().reorderList(head);
    Logs.print(head);
  }
}


```
