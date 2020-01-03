package leetcode120_Triangle;

import java.util.List;

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int level = triangle.size();
    int[] memo = new int[getNumbers(level) + 1];
    memo[1] = triangle.get(0).get(0);

    for (int i = 1; i < level; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          memo[getNumbers(i) + j + 1] = memo[getNumbers(i - 1) + j + 1] + triangle.get(i).get(j);
        } else if (j == i) {
          memo[getNumbers(i) + j + 1] = memo[getNumbers(i - 1) + j] + triangle.get(i).get(j);
        } else {
          memo[getNumbers(i) + j + 1] =
              getMinBetween(memo, getNumbers(i - 1) + j, getNumbers(i - 1) + j + 1)
                  + triangle.get(i).get(j);
        }
      }
    }

    return getMinBetween(memo, getNumbers(level - 1) + 1, getNumbers(level - 1) + level);
  }

  private int getMinBetween(int[] memo, int i, int j) {
    if (i >= j) {
      return memo[j];
    }
    return Math.min(memo[i], getMinBetween(memo, i + 1, j));
  }

  private int getNumbers(int level) {
    return level * (level + 1) / 2;
  }
}
