package leetcode76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
  private Map<Character, Integer> targetMap = new HashMap<>();

  public String minWindow(String s, String t) {
    for (char c : t.toCharArray()) {
      targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
    }

    int lowCursor = 0, highCursor = -1;
    int minLowCursor = 0, minHighCursor = -1;
    int minCount = s.length() + 1;
    boolean isTIncluded = false;

    while (highCursor < s.length() && lowCursor < s.length()) {

      // 只有在不包含t的字符和没有达到最后的一位的时候才需要变化
      while (highCursor < s.length() - 1 && !isTIncluded) {
        highCursor++;
        char currentChar = s.charAt(highCursor);

        if (targetMap.containsKey(currentChar)) {
          targetMap.put(currentChar, targetMap.get(currentChar) - 1);
          if (containTargetCharacters(t)) {
            isTIncluded = true;
          }
        }
      }

      while (isTIncluded && lowCursor < s.length()) {
        if (highCursor - lowCursor + 1 < minCount) {
          minHighCursor = highCursor;
          minLowCursor = lowCursor;
          minCount = highCursor - minLowCursor + 1;
        }
        char currentChar = s.charAt(lowCursor);
        if (targetMap.containsKey(currentChar)) {
          targetMap.put(currentChar, targetMap.get(currentChar) + 1);
          if (!containTargetCharacters(t)) {
            isTIncluded = false;
          }
        }
        lowCursor++;
      }

      if (highCursor == s.length() - 1) {
        break;
      }
    }

    char[] result = new char[minCount];
    if (minCount != s.length() + 1) {
      for (int i = minLowCursor; i <= minHighCursor; i++) {
        result[i - minLowCursor] = s.charAt(i);
      }
    }
    return minCount != s.length() + 1 ? new String(result) : "";
  }

  public boolean containTargetCharacters(String t) {
    for(Entry<Character, Integer> entry: targetMap.entrySet()){
      if(entry.getValue() >0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
//    System.out.println(new DPSolution().minWindow("a", "a"));
  }
}
