# Leetcode

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

# Solution

```java

package leetcode203_RemoveLinkedListElements;

import utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeElements(ListNode head, int val) {

    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;

    // when head node is not val;
    ListNode prev = dummyHead;
    while(prev != null &&  prev.next != null){
      if(prev.next.val == val){
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
      }else{
        prev = prev.next;
      }
    }
    return dummyHead.next;
  }
}

```
