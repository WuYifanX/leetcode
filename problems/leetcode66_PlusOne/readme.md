# Leetcode

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

```
Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

```

# Solution

```java
package leetcode66_PlusOne;

import java.util.Arrays;
import utils.Logs;

class Solution {
  public int[] plusOne(int[] digits) {
    return plusOneAt(digits, digits.length - 1);
  }

  private int[] plusOneAt(int[] digits, int index) {
    if (digits[index] != 9) {
      digits[index] = digits[index] + 1;
      return digits;
    }

    // digits must be 9;
    if (index == 0) {
      digits[0] = 1;
      int[] newints = Arrays.copyOf(digits, digits.length + 1);
      newints[digits.length] = 0;
      return newints;

    } else {
      digits[index] = 0;
      return plusOneAt(digits, index - 1);
    }
  }

  public static void main(String[] args) {
    Logs.print(new Solution().plusOne(new int[] {9, 9, 9}));
  }
}

// [9]
// [9,9,9]

```
