package leetcode345_ReverseVowelsofAString;

class Solution {
  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int lowerCursor = 0, higherCursor = s.length() - 1;

    while (lowerCursor < higherCursor) {
      while (lowerCursor < higherCursor && !isVowels(chars[lowerCursor])) {
        lowerCursor++;
      }

      while (lowerCursor < higherCursor && !isVowels(chars[higherCursor])) {
        higherCursor--;
      }

      if (lowerCursor < higherCursor) {
        char temp = chars[higherCursor];
        chars[higherCursor] = chars[lowerCursor];
        chars[lowerCursor] = temp;

        lowerCursor++;
        higherCursor--;
      }
    }
    return new String(chars);
  }

  private boolean isVowels(char c) {
    char charLowerCases = Character.toLowerCase(c);
    return charLowerCases == 'a'
        || charLowerCases == 'e'
        || charLowerCases == 'i'
        || charLowerCases == 'o'
        || charLowerCases == 'u';
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reverseVowels("hello"));
    System.out.println(new Solution().reverseVowels("leetcode"));
  }
}
