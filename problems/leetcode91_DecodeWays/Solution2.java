package leetcode91_DecodeWays;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
  private Map<String, Integer> memo;

  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) return 0;
    memo = new HashMap<>();
    return calculateDecodings(s);
  }

  private int calculateDecodings(String s) {
    if (s.equals("")) {
      return 1;
    }
    if (s.startsWith("0")) return 0;
    if (s.length() == 1) return 1;

    if (memo.containsKey(s)) return memo.get(s);
    int resultForIndexI;

    int number = Integer.valueOf(s.substring(0, 2));

    if (number > 26) {
      resultForIndexI = calculateDecodings(s.substring(1));
    } else {
      resultForIndexI = calculateDecodings(s.substring(1)) + calculateDecodings(s.substring(2));
    }

    memo.put(s, resultForIndexI);
    return resultForIndexI;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().numDecodings("01"));
  }
}
