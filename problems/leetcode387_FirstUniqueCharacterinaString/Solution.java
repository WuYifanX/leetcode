package leetcode387_FirstUniqueCharacterinaString;

import java.util.Arrays;

class Solution {
  public int firstUniqChar(String s) {
    if (s.length() == 0) return -1;
    int[] maps = new int[26];

    // -1 not init;
    // 0 - ++ index;
    // -2 is repeat.
    Arrays.fill(maps, -1);

    for (int i = 0; i < s.length(); i++) {
      if (maps[s.charAt(i) - 'a'] >= 0) {
        maps[s.charAt(i) - 'a'] = -2;
        continue;
      }

      if (maps[s.charAt(i) - 'a'] == -1) {
        maps[s.charAt(i) - 'a'] = i;
      }
    }

    int minIndex = s.length();
    for (int i = 0; i < 26; i++) {
      if (maps[i] == -2 || maps[i] == -1) continue;

      if (minIndex > maps[i]) minIndex = maps[i];
    }

    return minIndex == s.length() ? -1 : minIndex;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().firstUniqChar("leetcode"));
  }
}
