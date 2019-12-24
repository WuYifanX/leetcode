package leetcode242_ValidAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution1 {
  public boolean isAnagram(String s, String t) {
    return isAnagrams(s, 0, s.length() - 1, t);
  }

  private boolean isAnagrams(String s, int start, int end, String p) {
    if (end - start + 1 != p.length()) {
      return false;
    }

    Map<Character, Integer> maps = new HashMap<>(p.length());
    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      maps.put(c, maps.getOrDefault(c, 0) + 1);
    }

    for (int j = start; j <= end; j++) {
      char chars = s.charAt(j);
      if (!maps.containsKey(chars)) {
        return false;
      } else {
        maps.put(chars, maps.get(chars) - 1);
      }
    }

    for (Entry<Character, Integer> entry : maps.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution1().isAnagram("anagram", "nagaram"));
    System.out.println(new Solution1().isAnagram("rat", "car"));
  }
}
