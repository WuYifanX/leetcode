# Leetcode

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

# Solution

几个可能忽略的数据集:

 5 + 5 = 10
5 + 95 = 100

基本上注意到这几个特殊的用例就可以了


```java
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode l1Cursor = l1;
    ListNode l2Cursor = l2;
    int combinedValue = 0;

    ListNode dummy = new ListNode(0);
    dummy.next = null;

    ListNode resultCursor = dummy;
    while (l1Cursor != null && l2Cursor != null) {
      combinedValue = l1Cursor.val + l2Cursor.val + combinedValue / 10;

      resultCursor.next = new ListNode(combinedValue % 10);
      resultCursor = resultCursor.next;
      l1Cursor = l1Cursor.next;
      l2Cursor = l2Cursor.next;
    }

    while (l1Cursor != null) {
      combinedValue = l1Cursor.val + combinedValue / 10;
      resultCursor.next = new ListNode(combinedValue % 10);
      resultCursor = resultCursor.next;
      l1Cursor = l1Cursor.next;
    }

    while (l2Cursor != null) {
      combinedValue = l2Cursor.val + combinedValue / 10;

      resultCursor.next = new ListNode(combinedValue % 10);
      resultCursor = resultCursor.next;
      l2Cursor = l2Cursor.next;
    }

    if (combinedValue > 9) {
      resultCursor.next = new ListNode(combinedValue / 10);
    }

    return dummy.next;
  }
}

```

