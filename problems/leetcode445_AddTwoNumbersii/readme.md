# Leetcode

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7


# Solution

1. 使用了Deque的方法, 这个方法就是小心进位的细节. 
2. 此外还可以使用递归的方法来解决. 就是需要补0, 可以参考讨论区的答案.

```java

package leetcode445_AddTwoNumbersii;

import java.util.ArrayDeque;
import java.util.Deque;
import utils.ListNode;
import utils.Logs;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  private int addResult = 0;
  private ListNode dummy = new ListNode(0);

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    ListNode current = l1;

    while (current != null) {
      stack1.addLast(current.val);
      current = current.next;
    }

    current = l2;
    while (current != null) {
      stack2.addLast(current.val);
      current = current.next;
    }

    while (!stack1.isEmpty() && !stack2.isEmpty()) {
      addResult = stack1.pollLast() + stack2.pollLast() + addResult / 10;
      storeAddResultInLinkNode();
    }

    while (!stack1.isEmpty()) {
      addResult = stack1.pollLast() + addResult / 10;
      storeAddResultInLinkNode();
    }

    while (!stack2.isEmpty()) {
      addResult = stack2.pollLast() + addResult / 10;
      storeAddResultInLinkNode();
    }

    if (addResult > 9) {
      addResult = addResult / 10;
      storeAddResultInLinkNode();
    }

    return dummy.next;
  }

  private void storeAddResultInLinkNode() {
    ListNode temp = new ListNode(addResult % 10);
    temp.next = dummy.next;
    dummy.next = temp;
  }

  public static void main(String[] args) {
    int[] input = new int[] {7, 2, 4, 3};
    int[] input2 = new int[] {5, 6, 4};
    ListNode head = Logs.createListNodes(input);
    ListNode head2 = Logs.createListNodes(input2);
    Logs.print(new Solution().addTwoNumbers(head, head2));
  }
}

```


