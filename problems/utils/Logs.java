package utils;

import java.util.List;

public class Logs {
  public static void print(int[] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      System.out.print(arrays[i] + " ");
    }
    System.out.println();
  }

  public static void print(List<Integer> arrays) {
    for (int i = 0; i < arrays.size(); i++) {
      System.out.print(arrays.get(i) + " ");
    }
    System.out.println();
  }

  public static void print(ListNode head) {

    while (head != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.print("null");
    System.out.println();
  }

  public static ListNode createListNodes(int[] input) {
    ListNode head = new ListNode(input[0]);
    // 1 -> null
    ListNode current = head;
    for (int i = 1; i < input.length; i++) {
      current.next = new ListNode(input[i], null);
      current = current.next;
    }
    return head;
  }
}
