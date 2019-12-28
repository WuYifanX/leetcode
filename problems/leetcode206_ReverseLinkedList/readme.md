# Leetcode
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?


# Solution

1. solution: 使用了current, next, nextNext 操作太多, 很麻烦
2. solution2: 使用了prev, current, next能够简化操作.
3. Solution3: 使用递归的方式解决问题, 思考不那么直接, 但是代码更简单点.

```java

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode reverseList(ListNode head) {

    if (head == null) {
      return head;
    }

    ListNode current = head;
    ListNode next = current.next;
    current.next = null;

    ListNode nextNext;
    while (next != null) {
      nextNext = next.next;
      next.next = current;

      current = next;
      next = nextNext;
    }

    return current;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution().reverseList(head));
  }
}

```

```java

package leetcode206_ReverseLinkedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
// 与Solution的区别在于有prev, current, next指针. 操作的是current指针.
class Solution2 {
  public ListNode reverseList(ListNode head) {

    if (head == null) {
      return null;
    }
    ListNode prev = null;
    ListNode current = head;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  //  1->2->3->4->5->null
  //      5->4->3->2->1->null
  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution2().reverseList(head));
  }
}

```

```java

package leetcode206_ReverseLinkedList;

import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
// 与Solution2的这里使用递归的方法来实现.
class Solution3 {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    return reverse(head, null);
  }

  //  this function will reverse the listNode from current to the tail.
  private ListNode reverse(ListNode current, ListNode next) {

    if (current == null) {
      return null;
    }

    ListNode ans = reverse(current.next, current);
    current.next = next;
    return ans == null ? current : ans;
  }

  //  1->2->3->4->5->null
  //  5->4->3->2->1->null
  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(head);
    Logs.print(new Solution3().reverseList(head));
  }
}

```
