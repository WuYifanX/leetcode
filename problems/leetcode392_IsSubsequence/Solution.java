package leetcode392_IsSubsequence;

class Solution {
  public boolean isSubsequence(String s, String t) {
    if (t.length() < s.length()) return false;
    if (t.length() == 0 && s.length() == 0) return true;
    if (s.length() == 0) return true;

    int sIndex = 0;
    int tIndex = 0;

    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
        tIndex++;
      } else {
        tIndex++;
      }
    }

    return sIndex == s.length();
  }
}
