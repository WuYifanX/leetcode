package leetcode455_AssignCookies;

import java.util.Arrays;

class Solution {
  public int findContentChildren(int[] g, int[] s) {
    if (s.length == 0 || g.length == 0) return 0;

    Arrays.sort(g);
    Arrays.sort(s);

    int result = 0;

    if (g[0] > s[s.length - 1]) return result;

    int gIndex = g.length - 1;
    int sIndex = s.length - 1;

    while (gIndex >= 0 && sIndex >= 0) {
      if (s[sIndex] >= g[gIndex]) {
        sIndex--;
        gIndex--;
        result++;
      } else if (s[sIndex] < g[gIndex]) {
        gIndex--;
      }
    }

    return result;
  }
}
