# Leetcode

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

```

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


```
# Solution

1. 递归+记忆搜索: 难点在于说确定这个如何缓存搜索到的值.见Solution1 & Solution2
一个是使用了字符串作为k, 另外一个是使用了string的index作为key.比较有心意.


```java
package leetcode91_DecodeWays;

import java.util.Arrays;

public class Solution {
  private int[] memo;

  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) return 0;
    memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return calculateDecodings(s, 0, s.length() - 1);
  }

  private int calculateDecodings(String s, int i, int j) {
    if (i > j) {
      return 1;
    }
    if (s.charAt(i) == '0') return 0;
    if (i == j) return 1;

    if (memo[i] != -1) return memo[i];
    int resultForIndexI;

    int number = Integer.valueOf(s.substring(i, i + 2));

    if (number > 26) {
      resultForIndexI = calculateDecodings(s, i + 1, j);
    } else {
      resultForIndexI = calculateDecodings(s, i + 1, j) + calculateDecodings(s, i + 2, j);
    }

    memo[i] = resultForIndexI;
    return resultForIndexI;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().numDecodings("100"));
  }
}

```

```java
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

```

2. DP的方法解决: 

```java
package leetcode91_DecodeWays;

public class Solution4 {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) return 0;

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    int result;
    for (int i = 2; i < s.length() + 1; i++) {
      result = 0;

      if (!isValid(s.charAt(i - 1)) && !isValid(s.charAt(i - 2))) {
        return 0;
      }
      if (isValid(s.charAt(i - 1))) result += dp[i - 1];
      if (isValid(s.charAt(i - 2), s.charAt(i - 1))) result += dp[i - 2];

      dp[i] = result;
    }
    return dp[s.length()];
  }

  private boolean isValid(char a) {
    return a != '0';
  }

  public boolean isValid(char a, char b) {
    int number = (a - '0') * 10 + b - '0';
    return number >= 10 && number <= 26;
  }

  public static void main(String[] args) {
    System.out.println(new Solution4().numDecodings("228"));
  }
}

```
 
3. DP解决压缩数组:



