package leetcode71_SimplifyPath;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public String simplifyPath(String path) {
    Deque<String> deque = new ArrayDeque<>();

    String[] pathArray = path.split("/");
    for (String s : pathArray) {
      if (s.equals("") || s.equals(".")) {
        continue;
      } else if (s.equals("..")) {
        if (!deque.isEmpty()) deque.pop();
      } else {
        deque.push(s);
      }
    }

    StringBuilder sb = new StringBuilder();
    if (deque.isEmpty()) return "/";

    while (!deque.isEmpty()) {
      sb.append("/");
      sb.append(deque.pollLast());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().simplifyPath("/home/"));
    System.out.println(new Solution().simplifyPath("/../"));
    System.out.println(new Solution().simplifyPath("/home//foo/"));
    System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));
    System.out.println(new Solution().simplifyPath("/a//b////c/d//././/.."));
  }
}
