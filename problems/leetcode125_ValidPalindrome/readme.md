# Leetcode
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false



# Thoughts:
1. alphanumeric characters 指的是: a-z, A-Z, 0-9;
2. 如果使用b - a = 32的话, 0P也会成为问题.尽可能用Character.toLowerCase(c) 去判断最合理.


# Solution1:

1. 先过滤掉不需要的字符, 在判断, 最容易.
2. 双指针夹逼也可以. 注意终止条件.

```java

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
    Solution1
    boolean result = new Solution().isPalindrome("0P");
    System.out.println(result);
  }
}


```
