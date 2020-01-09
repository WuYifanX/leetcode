package leetcode13_RomantoInteger;

import java.util.HashMap;
import java.util.Map;

class Solution {

  private Map<Character, Integer> dict;

  public int romanToInt(String s) {
    if (s.length() == 0) return 0;
    initMap();

    if (s.length() == 1) return dict.get(s.charAt(0));

    int currentIndex = s.length() - 2;
    int prevIndex = s.length() - 1;

    int currentNumber, prevNumber;
    int result = dict.get(s.charAt(prevIndex));

    while (currentIndex >= 0) {
      currentNumber = dict.get(s.charAt(currentIndex));
      prevNumber = dict.get(s.charAt(prevIndex));

      if (currentNumber >= prevNumber) {
        result += currentNumber;
      } else {
        result -= currentNumber;
      }

      currentIndex--;
      prevIndex--;
    }

    return result;
  }

  private void initMap() {
    dict = new HashMap<>();
    dict.put('I', 1);
    dict.put('V', 5);
    dict.put('X', 10);
    dict.put('L', 50);
    dict.put('C', 100);
    dict.put('D', 500);
    dict.put('M', 1000);
  }

  public static void main(String[] args) {
    System.out.println(new Solution().romanToInt("MCMXCIV"));
  }
}
