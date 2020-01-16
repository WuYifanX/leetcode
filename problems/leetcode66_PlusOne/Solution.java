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
