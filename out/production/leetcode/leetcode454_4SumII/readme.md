# Leetcode

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

# Solution

1. A, B, C, D 分别生成2个数组AB, CD. 然后变成2SUM

```java

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

    int[] AB = generateCombineArrayOfTwoArray(A, B);
    int[] CD = generateCombineArrayOfTwoArray(C, D);

    int resultCount = 0;

    Map<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i <CD.length; i++) {
      maps.put(CD[i], maps.getOrDefault(CD[i], 0) +1);
    }

    for (int j = 0; j < AB.length; j++) {
      if(maps.containsKey(-AB[j])){
        resultCount += maps.get(-AB[j]);
      }
    }
    return resultCount;
  }

  private int[] generateCombineArrayOfTwoArray(int[] A, int[] B) {
    int[] result = new int[A.length * B.length];
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        result[count++] = A[i] + B[j];
      }
    }
    return result;
  }
}

```
