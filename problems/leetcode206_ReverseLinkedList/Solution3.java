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
