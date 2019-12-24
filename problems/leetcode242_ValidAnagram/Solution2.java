package leetcode242_ValidAnagram;

public class Solution2 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a'] += 1;
      count[t.charAt(i) - 'a'] -= 1;
    }

    for (int j = 0; j < 26; j++) {
      if (count[j] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().isAnagram("anagram", "nagaram"));
    System.out.println(new Solution2().isAnagram("atagram", "nagaram"));
  }
}
