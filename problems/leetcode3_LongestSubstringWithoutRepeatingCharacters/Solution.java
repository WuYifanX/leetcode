package leetcode3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();

    Set<Character> set = new HashSet<>();
    int left = 0;
    int right = 1;
    int result = 1;
    set.add(s.charAt(0));

    while (right < s.length()) {
      if (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      } else {
        set.add(s.charAt(right));
        result = Math.max(result, right - left + 1);
        right++;
      }
    }

    return result;
  }
}
