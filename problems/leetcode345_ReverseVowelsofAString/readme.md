# Leetcode

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".


# Thoughts:

1. 在没有说大小写的时候, 一定要注意这个是大小写都有的情况.

# Solution1:

```java

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
}
```
