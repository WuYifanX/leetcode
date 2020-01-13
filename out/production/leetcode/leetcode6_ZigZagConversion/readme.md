# Leetcode

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

```
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

```

# Solution


```java
package leetcode6_ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public String convert(String s, int numRows) {
    if (s.length() == 0 || s.length() == 1 || numRows == 1) return s;
    List<List<Character>> result = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      result.add(new ArrayList<>());
    }

    int currentIndex = 0;
    int arrayIndex = 0;
    boolean positive = true;
    while (currentIndex < s.length()) {
      result.get(arrayIndex).add(s.charAt(currentIndex));

      if (positive) {
        arrayIndex++;
        if (arrayIndex == numRows - 1) positive = false;
      } else {
        arrayIndex--;
        if (arrayIndex == 0) positive = true;
      }
      currentIndex++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.get(i).size(); j++) {
        sb.append(result.get(i).get(j));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().convert("AB", 2));
  }
}

```
