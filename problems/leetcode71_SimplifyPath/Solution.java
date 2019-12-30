package leetcode71_SimplifyPath;

class Solution {
  public String simplifyPath(String path) {

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
