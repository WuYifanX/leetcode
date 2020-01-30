package leetcode171_ExcelSheetColumnNumber;

class Solution {
  public int titleToNumber(String s) {
    if (s.length() == 0) return 0;
    int result = 0;

    int current;
    int digit = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      current = s.charAt(i) - 'A' + 1;
      result += current * Math.pow(26, digit);
      digit++;
    }

    return result;
  }
}
