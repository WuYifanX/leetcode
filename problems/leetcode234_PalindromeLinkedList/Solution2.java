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
