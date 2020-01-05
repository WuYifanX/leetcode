package leetcode17_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;
import utils.Logs;

class Solution {

  private String[] letterMap = {
    " ", // 0
    "", // 1
    "abc", // 2
    "def", // 3
    "ghi", // 4
    "jkl", // 5
    "mno", // 6
    "pqrs", // 7
    "tuv", // 8
    "wxyz" // 9
  };
  private List<String> result = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) return result;
    generateString(digits, 0, "");
    return result;
  }

  private void generateString(String digits, int index, String stringResult) {
    if (index == digits.length()) {
      result.add(stringResult);
      return;
    }

    String letter = letterMap[digits.charAt(index) - '0'];

    for (char c : letter.toCharArray()) {
      generateString(digits, index + 1, stringResult + c);
    }
  }

  public static void main(String[] args) {
    Logs.print(new Solution().letterCombinations("23"));
  }
}
