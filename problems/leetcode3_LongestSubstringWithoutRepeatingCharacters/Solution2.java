package leetcode3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();

    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 1;
    int result = 1;
    map.put(s.charAt(0), 0);

    while (right < s.length()) {
      if (map.containsKey(s.charAt(right))) {
        int nextIndex = map.get(s.charAt(right)) + 1;
        while (left != nextIndex) {
          map.remove(s.charAt(left));
          left++;
        }
        map.put(s.charAt(right), right);
      } else {
        map.put(s.charAt(right), right);
        result = Math.max(result, right - left + 1);
      }
      right++;
    }

    return result;
  }
}
