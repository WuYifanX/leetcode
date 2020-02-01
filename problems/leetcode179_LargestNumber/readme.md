# Leetcode
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

# Solution

```java
package leetcode179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public String largestNumber(int[] nums) {
    if (nums.length == 0) return "0";
    if (nums.length == 1) return "" + nums[0];

    String[] strings = new String[nums.length];

    for (int i = 0; i < nums.length; i++) {
      strings[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(strings, new MyComparator());

    if (strings[0].charAt(0) == '0') return "0";

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strings.length; i++) {
      sb.append(strings[i]);
    }
    return sb.toString();
  }

  private class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      String order1 = o1 + o2;
      String order2 = o2 + o1;

      return order2.compareTo(order1);
    }
  }
}

```
