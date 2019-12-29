package leetcode148_SortList;

import utils.ListNode;
import utils.Logs;

class Solution {
  public ListNode sortList(ListNode head) {
    return null;
  }

  public static void main(String[] args) {
    int[] input = new int[] {4, 3232, 121, 2, 1, 2, 3, 4, 5};
    ListNode head = Logs.createListNodes(input);
    Logs.print(new Solution().sortList(head));
  }
}
