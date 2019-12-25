package leetcode290_WordPattern;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] strArray = str.split(" ");
    if (strArray.length != pattern.length()) {
      return false;
    }

    String[] charDict = new String[26];
    int charDictIndex;
    for (int i = 0; i < pattern.length(); i++) {
      charDictIndex = pattern.charAt(i) - 'a';
      if (charDict[charDictIndex] == null) {
        if (isWordAlreadySavedInDict(charDict, strArray[i])) {
          return false;
        } else {
          charDict[charDictIndex] = strArray[i];
        }
      } else {
        if (!charDict[charDictIndex].equals(strArray[i])) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isWordAlreadySavedInDict(String[] dict, String word) {
    for (int i = 0; i < dict.length; i++) {
      if (dict[i] != null && dict[i].equals(word)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
  }
}
