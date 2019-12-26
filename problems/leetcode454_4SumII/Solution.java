package leetcode454_4SumII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

    int[] AB = generateCombineArrayOfTwoArray(A, B);
    int[] CD = generateCombineArrayOfTwoArray(C, D);

    int resultCount = 0;

    Map<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i < CD.length; i++) {
      maps.put(CD[i], maps.getOrDefault(CD[i], 0) + 1);
    }

    for (int j = 0; j < AB.length; j++) {
      if (maps.containsKey(-AB[j])) {
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

  public static void main(String[] args) {
    int[] a = new int[] {1, 2};
    int[] b = new int[] {-1, -2};
    int[] c = new int[] {-1, 2};
    int[] d = new int[] {0, 2};
    System.out.println(new Solution().fourSumCount(a, b, c, d));
  }
}
