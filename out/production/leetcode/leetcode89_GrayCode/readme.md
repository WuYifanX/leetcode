# Leetcode

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].



# Solution

1. 回溯法可以解决: 但是和普通的递归树不太一样的是, 这里的顺序有点特殊
如果现在的1的个数是奇数, 那么就是10, 如果是偶数, 那么就是01.
此外, 因为是二进制的加位数, 那么这个可以通过简单的计算得出结果.

2. DP
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<Integer> result = new ArrayList<>();

  public List<Integer> grayCode(int n) {
    if (n == 0) {
      result.add(0);
      return result;
    }
    dfs(n, 0, 0);
    return result;
  }

  private void dfs(int left, int oneCount, int number) {
    if (left == 0) {
      result.add(number);
      return;
    }

    if (oneCount % 2 == 0) {
      dfs(left - 1, oneCount, number * 2);
      dfs(left - 1, oneCount + 1, number * 2 + 1);
    } else {
      dfs(left - 1, oneCount + 1, number * 2 + 1);
      dfs(left - 1, oneCount, number * 2);
    }
  }

}

```


2. 
