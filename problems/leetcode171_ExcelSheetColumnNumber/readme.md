# Leetcode

Given a column title as appear in an Excel sheet, return its corresponding column number.

```
For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
```
# Solution

1. 计算进制.

```java
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

```

