# Leetcode

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?


# Solution

1. 需要在O(1)的空间, O(n)的时间来实现还是需要点技巧的, 这里需要逆转一半的链表来实现
2. 暴力的做法肯定是转化成为数组来做了.
3. 更牛逼的做法是, 在遍历的过程中就开始逆转前半部分的链表了, 可以参考Solution2


```java
package leetcode234_PalindromeLinkedList;

import utils.ListNode;
import utils.Logs;

class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode fastCursor = head.next;
    ListNode slowCursor = head;
    boolean isListOddCount = false;
    while (fastCursor.next != null) {
      fastCursor = fastCursor.next;
      if (fastCursor.next == null) {
        isListOddCount = true;
        break;
      }

      fastCursor = fastCursor.next;
      slowCursor = slowCursor.next;
    }

    fastCursor = slowCursor.next;
    if (isListOddCount) fastCursor = fastCursor.next;

    reverseListFromStartNodeToEndNode(head, slowCursor);



    while (fastCursor != null && slowCursor != null) {
      if (fastCursor.val != slowCursor.val) return false;
      fastCursor = fastCursor.next;
      slowCursor = slowCursor.next;
    }

    return fastCursor == null && slowCursor == null;
  }

  public void reverseListFromStartNodeToEndNode(ListNode startNode, ListNode endNode) {

    ListNode current = startNode;
    ListNode next = current.next;
    ListNode nextNext = next.next;
    current.next = null;
    while (current != endNode) {
      next.next = current;
      current = next;
      next = nextNext;
      nextNext = nextNext.next;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 0, 1};
    ListNode head = Logs.createListNodes(input);
    System.out.println(new Solution().isPalindrome(head));
  }
}


```

```java

package leetcode234_PalindromeLinkedList;

import utils.ListNode;
import utils.Logs;

class Solution2 {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode leftCursor = head;
    ListNode rightCursor = head.next;
    boolean isOddLengthList = false;
    ListNode leftPrev = dummy;
    ListNode leftPrevPrev = null;
    while (rightCursor.next != null) {
      rightCursor = rightCursor.next;
      if (rightCursor.next == null) {
        isOddLengthList = true;
        break;
      }

      rightCursor = rightCursor.next;

      leftPrevPrev = leftPrev;
      leftPrev = leftCursor;
      leftCursor = leftCursor.next;

      leftPrev.next = leftPrevPrev;
    }
    if (isOddLengthList) {
      rightCursor = leftCursor.next.next;
    } else {
      rightCursor = leftCursor.next;
    }
    leftCursor.next = leftPrev;

    while (leftCursor != dummy && rightCursor != null) {
      if (leftCursor.val != rightCursor.val) return false;
      leftCursor = leftCursor.next;
      rightCursor = rightCursor.next;
    }
    return leftCursor == dummy && rightCursor == null;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 0, 1};
    ListNode head = Logs.createListNodes(input);
    System.out.println(new Solution2().isPalindrome(head));
  }
}

```
