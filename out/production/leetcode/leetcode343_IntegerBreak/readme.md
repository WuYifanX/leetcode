# Leetcode

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

```

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.


```
# Solution

1. 递归加上记忆划搜索. 结果一定是在
```
1*(n-1),这种情况分为(n-1)拆分, (n -1) 不拆.如果拆, 那么那么这个结果就是memo[n-1].
2*(n-2), 同理
3*(n-3),
4*(n-4)
..之中

```

2. DP求解, 自定向下解决问题.

```java
package leetcode343_IntegerBreak;

class Solution {
  private int[] memo = new int[59];

  public int integerBreak(int n) {
    // memo[i] means the result of integer break of i;
    memo[1] = 1;
    memo[2] = 1;

    return calculateMaxBreak(n);
  }

  public int calculateMaxBreak(int n) {
    if (memo[n] != 0) return memo[n];
    int maxValue = 0;
    int temp;
    for (int i = 1; i < n; i++) {
      temp = Math.max(i * calculateMaxBreak(n - i), i * (n - i));
      maxValue = Math.max(temp, maxValue);
    }
    memo[n] = maxValue;
    return memo[n];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().integerBreak(2));
  }
}

```

Solution2
```java

class Solution {
  private int[] memo = new int[59];

  public int integerBreak(int n) {
    // memo[i] means the result of integer break of i;
    memo[1] = 1;
    memo[2] = 1;
    int maxValue;
    if (memo[n] != 0) return memo[n];
    for (int i = 3; i < n + 1; i++) {
      maxValue = 0;
      for (int j = 1; j < i; j++) {
        maxValue = max3(maxValue, j * (i - j), j * memo[i - j]);
      }
      memo[i] = maxValue;
    }

    return memo[n];
  }

  private int max3(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }
}

```
