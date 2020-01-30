package leetcode160_IntersectionofTwoLinkedLists;

import utils.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    int aLength = 1;
    int bLength = 1;
    ListNode cursor = headA;

    while (cursor.next != null) {
      aLength++;
      cursor = cursor.next;
    }

    cursor = headB;
    while (cursor.next != null) {
      bLength++;
      cursor = cursor.next;
    }

    ListNode longerList, shorterList;
    int skipSteps;
    if (aLength > bLength) {
      longerList = headA;
      shorterList = headB;
      skipSteps = aLength - bLength;
    } else {
      longerList = headB;
      shorterList = headA;
      skipSteps = bLength - aLength;
    }

    while (skipSteps > 0) {
      longerList = longerList.next;
      skipSteps--;
    }

    while (longerList != null && shorterList != null) {
      if (longerList == shorterList) return longerList;
      longerList = longerList.next;
      shorterList = shorterList.next;
    }

    return null;
  }
}
