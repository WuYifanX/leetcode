package leetcode205_IsomorphicStrings;

class Solution {
  public boolean isIsomorphic(String s, String t) {
    Character[] charDict = new Character[128];
    char sChar;
    char tChar;

    for (int i = 0; i < s.length(); i++) {
      sChar = s.charAt(i);
      tChar = t.charAt(i);
      if (charDict[sChar] == null) {
        if (isCharacterAlreadySavedInDict(charDict, tChar)) {
          return false;
        } else {
          charDict[sChar] = tChar;
        }
      } else {
        if (charDict[sChar] != tChar) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isCharacterAlreadySavedInDict(Character[] dict, Character tChar) {
    for (int i = 0; i < dict.length; i++) {
      if (dict[i] != null && dict[i] == (tChar)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isIsomorphic("egg", "add"));
    System.out.println(new Solution().isIsomorphic("foo", "bar"));
    System.out.println(new Solution().isIsomorphic("paper", "title"));
    System.out.println(new Solution().isIsomorphic("13", "42"));
  }
}
