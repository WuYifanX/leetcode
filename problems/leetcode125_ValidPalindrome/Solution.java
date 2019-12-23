package leetcode125_ValidPalindrome;

public class Solution {

  public boolean isPalindrome(String s) {

    int lowerPointer = 0;
    int higherPointer = s.length() - 1;

    while (lowerPointer < higherPointer) {
      while (lowerPointer < higherPointer && !isValidCharacter(s.charAt(lowerPointer))) {
        lowerPointer++;
      }

      while (lowerPointer < higherPointer && !isValidCharacter(s.charAt(higherPointer))) {
        higherPointer--;
      }

      if (lowerPointer < higherPointer) {
        if (!isSameCharacterIgnoringCases(s.charAt(lowerPointer), s.charAt(higherPointer))) {
          return false;
        }
        lowerPointer++;
        higherPointer--;
      }
    }
    return true;
  }

  private boolean isValidCharacter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
  }

  private boolean isSameCharacterIgnoringCases(char a, char b) {
    if (isValidCharacter(a) && isValidCharacter(b)) {
      return Character.toLowerCase(a) == Character.toLowerCase(b);
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    //            boolean result = new Solution().isPalindrome("A man, a plan, a canal: Panama");
    boolean result = new Solution().isPalindrome("0P");
    System.out.println(result);
  }
}
