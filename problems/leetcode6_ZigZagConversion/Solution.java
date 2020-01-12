package leetcode6_ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public String convert(String s, int numRows) {
    if (s.length() == 0 || s.length() == 1 || numRows == 1) return s;
    List<List<Character>> result = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      result.add(new ArrayList<>());
    }

    int currentIndex = 0;
    int arrayIndex = 0;
    boolean positive = true;
    while (currentIndex < s.length()) {
      result.get(arrayIndex).add(s.charAt(currentIndex));

      if (positive) {
        arrayIndex++;
        if (arrayIndex == numRows - 1) positive = false;
      } else {
        arrayIndex--;
        if (arrayIndex == 0) positive = true;
      }
      currentIndex++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.get(i).size(); j++) {
        sb.append(result.get(i).get(j));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().convert("AB", 2));
  }
}
