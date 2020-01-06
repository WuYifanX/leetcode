package leetcode93_RestoreIPAddresses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// "010010"
class Solution {
  private List<String> result = new ArrayList<>();
  private Deque<String> stack;

  public List<String> restoreIpAddresses(String s) {
    if (s.length() == 0) return result;

    stack = new ArrayDeque<>();
    restoreIp(s, 0);
    return result;
  }

  private void restoreIp(String s, int start) {
    if (s.length() == start && stack.size() == 4) {
      String ip = String.join(".", new ArrayList<>(stack));
      result.add(ip);
    }

    if (stack.size() >= 4) return;

    for (int i = start; i < s.length() && i < start + 3; i++) {
      if (!isValidIpNumber(s, start, i)) {
        continue;
      }
      stack.addLast(s.substring(start, i + 1));
      restoreIp(s, i + 1);
      stack.removeLast();
    }
  }

  private boolean isValidIpNumber(String s, int start, int end) {
    String current = s.substring(start, end + 1);
    if (current.equals("0")) return true;

    if (current.startsWith("0")) return false;

    if (Integer.valueOf(current) > 255) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().restoreIpAddresses("010010"));
  }
}
